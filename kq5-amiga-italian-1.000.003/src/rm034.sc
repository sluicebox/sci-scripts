;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use CDActor)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm034 0
)

(local
	local0
	local1
	local2
	[local3 5] = [2 0 3 1 2]
	[local8 8] = [175 173 175 189 31 189 31 187]
	[local16 8] = [159 151 210 151 209 156 158 156]
	[local24 12] = [0 0 119 145 74 159 36 159 29 166 0 171]
	local36
)

(instance rm034 of KQ5Room
	(properties
		picture 34
		horizon 125
		north 92
		south 33
		west 33
	)

	(method (init)
		(super init:)
		(gEgo view: 12 posn: 7 173)
		(= local2 1)
		(self setFeatures: path34 aCastle)
		(if
			(and
				(!= ((gInventory at: 19) owner:) 34) ; Leg_of_Lamb
				(!= ((gInventory at: 2) owner:) 34) ; Pie
			)
			(eagleHead setPri: 13 init: stopUpd: hide:)
			(eagle init: stopUpd: setScript: eagleScript)
			(gGlobalSound2 number: 12 loop: 1 play:)
		)
		(gEgo init:)
		(poly1 points: @local8 size: 4)
		(poly2 points: @local16 size: 4)
		(poly3 points: @local24 size: 6)
		(self addObstacle: poly1 poly2 poly3)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				(gCurRoom newRoom: temp0)
			)
			((and (& (= temp1 (gEgo onControl: 0)) $0200) (== local2 1))
				(HandsOff)
				(= local2 2)
				(self setScript: walkOver)
			)
			((& temp1 $2000)
				(HandsOff)
				(gEgo priority: 13 signal: (| (gEgo signal:) $0010))
				(self setScript: falling)
			)
			((& temp1 $4000)
				(HandsOff)
				(gEgo priority: 11 signal: (| (gEgo signal:) $0010))
				(self setScript: falling)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(gGlobalSound fade:)
		(super dispose:)
	)
)

(instance duneLooper of Script
	(properties)

	(method (doit)
		(gEgo loop: [local3 (/ (+ (gEgo heading:) 13) 90)])
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 78
					setLoop: 0
					cel: 0
					setCycle: End self
					illegalBits: 0
				)
			)
			(1
				(PrintDC 34 0 #at 20 20 #dispose) ; "Aaaaiiiieeeeeeee!!"
				(gEgo
					yStep: 8
					setMotion: MoveTo (+ (gEgo x:) 20) 230 self
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(cls)
				(= global330
					{That last step was a doozy!}
				)
				(EgoDead)
			)
		)
	)
)

(instance walkOver of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo
					illegalBits: 0
					looper: duneLooper
					setMotion: MoveTo (gEgo x:) 195 self
					setPri: 4
				)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 16
					setStep: 2 1
					looper: MyLooper
					setMotion: MoveTo 119 140 self
				)
			)
			(2
				(gGlobalSound2 number: 91 loop: -1 play:)
				(wolf1
					init:
					setPri: 3
					setStep: 2 1
					setCycle: Walk
					moveSpeed: 1
					setMotion: MoveTo (- (gEgo x:) 5) (gEgo y:) self
				)
				(wolf2
					init:
					setStep: 2 1
					setCycle: Walk
					moveSpeed: 1
					setMotion: MoveTo (+ (gEgo x:) 5) (gEgo y:) self
				)
				(gEgo
					view: 538
					loop: 8
					cel: 0
					cycleSpeed: 2
					setPri: -1
					setCycle: End self
				)
			)
			(3)
			(4)
			(5
				(= temp0 (gGame egoMoveSpeed:))
				(wolf1 setLoop: 2 moveSpeed: temp0 setMotion: MoveTo 141 118)
				(wolf2 setLoop: 2 moveSpeed: temp0 setMotion: MoveTo 151 118)
				(gEgo
					view: 16
					moveSpeed: temp0
					setCycle: Fwd
					cycleSpeed: 0
					loop: 3
					setMotion: MoveTo 147 118 self
				)
			)
			(6
				(SetScore 2)
				(gCurRoom newRoom: 92)
			)
		)
	)
)

(instance talkEagleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 165 154 self)
			)
			(1
				(= seconds 2)
			)
			(2
				(proc0_28 165 34 1 67 10 10 25 4) ; "What's wrong, Mr....uh, Eagle?"
				(proc0_28 161 34 2 67 60 10 25 9) ; "I'm so weak from hunger. I haven't been able to catch any food for days. I can barely fly anymore."
				(proc0_28 165 34 3 67 10 10 25 7) ; "I'd love to help you...let me see what I can do."
				(proc0_28 161 34 4 67 60 10 25 5) ; "Thank you. I need food...(cough, cough)."
				(eagleHead stopUpd:)
				(eagle stopUpd:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance eagleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eagleHead hide:)
				(eagle loop: 1 cel: 0 cycleSpeed: 3 setCycle: End)
				(= state (Random -1 0))
				(= seconds (Random 5 15))
			)
			(1
				(eagle stopUpd:)
				(eagleHead show: setCycle: End)
				(gGlobalSound3 number: 864 loop: 1 vol: 127 play:)
				(eagle loop: 2 cel: 0)
				(= state (Random -1 0))
				(= seconds (Random 5 15))
			)
		)
	)
)

(instance feedEagle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound2 number: 49 loop: -1 play:)
				(gEgo setMotion: PolyPath 165 154 self)
			)
			(1
				(proc0_28 165 34 5 67 10 10 25 7) ; "Here, take this. Perhaps it will help you."
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 530
					loop: (if local36 9 else 8)
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gEgo
					normal: 1
					view: 12
					loop: 7
					cel: 0
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
				(eagleHead hide:)
				(eagle loop: 4 setCycle: End self)
				(if local36
					(lamb loop: 10)
				)
				(lamb init:)
				(gGlobalSound3 number: 864 loop: 1 vol: 127 play:)
			)
			(3
				(eagle loop: 5 setCycle: CT 2 1 self)
			)
			(4
				(eagle setCycle: End)
				(= cycles 25)
				(++ local1)
				(lamb cel: local1)
				(if (< local1 5)
					(-= state 2)
				)
			)
			(5
				(eagle loop: 7 setCycle: End self)
				(lamb dispose:)
			)
			(6
				(proc0_28 161 34 6 67 60 10 25 10) ; "You are a kind man to share your meager food with a poor bird...especially up here, in the snowy mountains."
				(proc0_28 165 34 7 67 10 10 25 10) ; "Well, I couldn't just stand there and let you starve to death! What kind of person would I be?"
				(proc0_28 161 34 8 67 60 10 25 10) ; "You have shown yourself to be a kind, compassionate man and I will not forget what you did for me. Good-bye, dear friend."
				(eagleHead dispose:)
				(eagleWing dispose:)
				(eagle setScript: 0)
				(eagle view: 532 loop: 0 cel: 0 setCycle: End self)
				(gGlobalSound3 number: 864 loop: 1 vol: 127 play:)
			)
			(7
				(eagle
					posn: 236 116
					setCycle: Walk
					setLoop: 1
					setMotion: MoveTo 360 (eagle y:) self
				)
			)
			(8
				(gGlobalSound2 fade:)
				(eagle dispose:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance eagleTalk of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(eagle view: 531 loop: 0 stopUpd:)
				(eagleHead
					view: 531
					loop: 1
					show:
					posn: 194 121
					cel: (Random (- (eagleHead cel:) 1) (+ (eagleHead cel:) 1))
					stopUpd:
				)
				(eagleWing
					cel: (Random (- (eagleWing cel:) 1) (+ (eagleWing cel:) 1))
					stopUpd:
				)
				(= cycles 2)
				(-- state)
			)
		)
	)
)

(instance path34 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
					(not (& (OnControl CONTROL (event x:) (event y:)) $4000))
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 34 9) ; "A snowy path leads from the mountain ridge to a mysterious, ice-covered castle."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance aCastle of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 34 10) ; "A castle, buried in snow and ice, perches precariously atop a steep pinnacle."
					(event claimed: 1)
				)
				(3 ; Do
					(gEgo setMotion: PolyPath 119 140)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance lamb of Prop
	(properties
		x 183
		y 137
		view 530
		loop 6
	)
)

(instance eagleWing of Prop
	(properties
		x 186
		y 128
		view 531
		loop 2
		signal 16384
	)

	(method (handleEvent event)
		(eagle handleEvent: event)
	)
)

(instance eagleHead of Prop
	(properties
		x 190
		y 121
		view 530
		loop 3
		signal 16384
	)

	(method (handleEvent event)
		(eagle handleEvent: event)
	)
)

(instance eagle of Actor
	(properties
		x 188
		y 137
		view 530
		signal 16384
		detailLevel 3
		illegalBits 0
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 34 11) ; "A shivering eagle perches weakly upon a small rock. Despite his own problems, Graham's heart goes out to the poor thing."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 34 12) ; "The poor eagle gives Graham a pitiful look. Graham would like to help him...but how?"
					(event claimed: 1)
				)
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(19
							(self setScript: 0)
							(SetScore 3)
							(gEgo put: 19 34) ; Leg_of_Lamb
							(HandsOff)
							(gCurRoom setScript: feedEagle)
							(event claimed: 1)
						)
						(2
							(self setScript: 0)
							(= local36 1)
							(gEgo put: 2 34) ; Pie
							(HandsOff)
							(gCurRoom setScript: feedEagle)
							(event claimed: 1)
						)
						(28
							(event claimed: 0)
						)
						(else
							(PrintDC 34 13) ; "That won't help the poor eagle."
							(event claimed: 1)
						)
					)
				)
				(5 ; Talk
					(if local0
						(PrintDC 34 14) ; "The eagle appears to be too weak to indulge in any further conversation."
						(event claimed: 1)
					else
						(= local0 1)
						(self setScript: talkEagleScript)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance wolf1 of Actor
	(properties
		x 160
		y 110
		view 538
		loop 5
		signal 26624
		illegalBits 0
	)
)

(instance wolf2 of Actor
	(properties
		x 162
		y 115
		view 538
		loop 5
		signal 26624
		illegalBits 0
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

