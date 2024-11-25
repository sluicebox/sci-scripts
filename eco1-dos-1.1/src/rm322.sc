;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 322)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use eRS)
(use n819)
(use Talker)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm322 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm322 of EcoRoom
	(properties
		picture 320
		style 7
		horizon 90
		south 321
	)

	(method (init)
		(= global250 1)
		(= global251 1)
		(= local4 (not (IsFlag 62)))
		(NormalEgo)
		(gEgo
			x: 150
			init:
			illegalBits: $8000
			ignoreHorizon: 1
			ignoreActors: 0
		)
		((gEgo cycler:) caller: sepEgoDel)
		(super init: &rest)
		(gAddToPics
			add:
				shipATP
				junkPlume
				j1
				j2
				j3
				j4
				j5
				j6
				j7
				j9
				j10
				j11
				j12
				j13
				j14
				j16
			eachElementDo: #init
			doit:
		)
		(spew setCycle: Fwd init:)
		(gLongSong2 number: 321 loop: -1 flags: 1 play:)
		(shipFlags1 setCycle: Fwd init:)
		(shipFlags2 setCycle: Fwd init:)
		(shipFlags3 setCycle: Fwd init:)
		(if (not (IsFlag 248))
			(jar init: stopUpd:)
		)
		(j17 init:)
		(j18 init:)
		(j19 init:)
		(j20 init:)
		(j21 init:)
		(j22 init:)
		(j23 init:)
		(j24 init:)
		(j25 init:)
		(j26 init:)
		(j27 init:)
		(j28 init:)
		(j29 init:)
		(j30 init:)
		(gFeatures add: sky water eachElementDo: #init)
		(boy init: cel: (if (IsFlag 62) 7 else 0))
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(self setScript: toWest)
			)
			((& (gEgo onControl: 1) $0004)
				(self setScript: pushEgoBack)
			)
			((< (gEgo y:) 122)
				(if (< (gEgo x:) 165)
					(Narrator init: 1 0 0 14) ; "Adam can't get through the flow of garbage."
				else
					(Narrator init: 1 0 0 16) ; "The wake from the ship pushes Adam back where he started."
				)
				(gEgo setMotion: 0 posn: (gEgo x:) 124)
			)
		)
		(if (and local4 (User canControl:))
			(HandsOff)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(gLongSong2 fade: flags: 0)
		(super newRoom: newRoomNumber &rest)
	)

	(method (notify)
		(if argc
			(SetScore 10 249)
			(self setScript: goDiving)
		)
	)
)

(instance sepEgoDel of Script
	(properties)

	(method (cue param1)
		(if param1
			(gDelph dispose:)
		else
			(gDelph
				view: 826
				init:
				setCycle: Fwd
				x:
					(switch (gEgo loop:)
						(3
							(- (gEgo x:) 2)
						)
						(2
							(gEgo x:)
						)
						(0
							(+ (gEgo x:) 18)
						)
						(1
							(- (gEgo x:) 18)
						)
						(7
							(- (gEgo x:) 10)
						)
						(6
							(+ (gEgo x:) 10)
						)
						(5
							(- (gEgo x:) 16)
						)
						(4
							(+ (gEgo x:) 16)
						)
					)
				y:
					(switch (gEgo loop:)
						(3
							(- (gEgo y:) 12)
						)
						(2
							(+ (gEgo y:) 12)
						)
						(7
							(- (gEgo y:) 7)
						)
						(5
							(+ (gEgo y:) 8)
						)
						(6
							(- (gEgo y:) 7)
						)
						(4
							(+ (gEgo y:) 8)
						)
						(else
							(- (gEgo y:) 2)
						)
					)
				loop: (gEgo loop:)
			)
			(if (not (IsFlag 62))
				(boy setScript: boyLosesBalloons)
			)
		)
	)
)

(instance goDiving of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					put: 9 ; airTanks
					setCycle: 0
					view: 810
					setLoop: 0
					cel: 0
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(1
				(Narrator init: 1 0 0 21) ; "Adam checks the pressure in his tanks, wets his mask, and clears his regulator."
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gLongSong fade:)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance toWest of Script
	(properties)

	(method (doit)
		(if (User canControl:)
			(switch (gEgo edgeHit:)
				(EDGE_TOP
					(Narrator init: 1 0 0 18) ; "The island has been deserted for a long time. There's nothing interesting about it."
					(gEgo setMotion: 0 y: 94)
				)
				(EDGE_RIGHT
					(Narrator init: 1 0 0 14) ; "Adam can't get through the flow of garbage."
					(gEgo setMotion: 0 x: 313)
				)
				(EDGE_LEFT
					(gEgo setMotion: 0 x: 7)
				)
				(EDGE_BOTTOM
					((ScriptID 2 0) init: 3 0 0 2 1) ; Delphineus, "Put those human things on, Adam!"
					(gEgo
						setMotion: 0
						posn: (gEgo x:) 187
						setHeading: 360
					)
				)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -38 (gEgo y:) self)
				(if (gCast contains: gDelph)
					(gDelph setMotion: MoveTo -38 (gEgo y:) talkScript: 0)
				)
				(gLongSong2 fade:)
			)
			(1
				(shipFlags1 startUpd: dispose:)
				(shipFlags2 startUpd: dispose:)
				(shipFlags3 startUpd: dispose:)
				(balloons startUpd: dispose:)
				(boy startUpd: dispose:)
				(jar startUpd: dispose:)
				(gAddToPics
					eachElementDo: #dispose
					delete:
						shipATP
						junkPlume
						j1
						j2
						j3
						j4
						j5
						j6
						j7
						j9
						j10
						j11
						j12
						j13
						j14
						j16
					release:
					doit:
				)
				(= cycles 1)
			)
			(2
				(j17 startUpd: dispose:)
				(j18 startUpd: dispose:)
				(j19 startUpd: dispose:)
				(j20 startUpd: dispose:)
				(j21 startUpd: dispose:)
				(j22 startUpd: dispose:)
				(j23 startUpd: dispose:)
				(j24 startUpd: dispose:)
				(j25 startUpd: dispose:)
				(j26 startUpd: dispose:)
				(j27 startUpd: dispose:)
				(j28 startUpd: dispose:)
				(j29 startUpd: dispose:)
				(j30 startUpd: dispose:)
				(spew startUpd: dispose:)
				(gDelph startUpd: dispose:)
				(gCurRoom drawPic: 320 -32759)
				(gAddToPics add: island doit:)
				(island init:)
				(NormalEgo)
				(gEgo
					x: 280
					edgeHit: EDGE_NONE
					illegalBits: $8000
					setMotion: MoveTo 160 130 self
				)
			)
			(3
				((gEgo cycler:) caller: sepEgoDel)
				(= cycles 100)
			)
			(4
				(gEgo setCycle: 0 view: 818 cycleSpeed: 17 setCycle: Fwd)
				(gFeatures addToFront: dive)
				(dive init:)
				(HandsOn)
				(= local2 1)
				(SetFlag 68)
				(= cycles 60)
			)
			(5
				((ScriptID 2 0) init: 3 0 0 3 1 self) ; Delphineus, "Time to dive, Adam! We're close to the boundaries of my kingdom, Eluria! Do you still want to go on?"
			)
			(6
				((ScriptID 2 1) init: 2 0 0 2 1 self) ; Adam, "Oh, yes, Delphineus! Do you think your friends will let me help?"
			)
			(7
				((ScriptID 2 0) init: 3 0 0 4 1 self) ; Delphineus, "Maybe not at first, Adam. They're pretty afraid of humans, you know. Bad experiences and all that. But they sent me for help and I'm bringing it. I'm bringing you! Get ready to dive!"
			)
			(8
				(= seconds 5)
			)
			(9
				(if (gEgo script:)
					(-- state)
					(= seconds 4)
				else
					((ScriptID 2 0) init: 3 0 0 1 1 self) ; Delphineus, "Adam, I can't wait much longer! Get ready to dive!"
				)
			)
			(10
				(= seconds 5)
			)
			(11
				(if (gEgo script:)
					(-- state)
					(= seconds 4)
				else
					((ScriptID 2 0) init: 3 0 0 2 1 self) ; Delphineus, "Put those human things on, Adam!"
				)
			)
			(12
				(= seconds 6)
			)
			(13
				(ClearFlag 68)
				(gEgo setScript: 0)
				(client setScript: goDiving)
			)
		)
	)
)

(instance pushEgoBack of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					y: (- (gEgo y:) 7)
					setLoop: (gEgo loop:)
					setMotion: MoveTo (- (gEgo x:) 30) (gEgo y:) self
				)
			)
			(1
				(gEgo setLoop: -1 setMotion: 0)
				(= ticks 10)
			)
			(2
				(Narrator init: 1 0 0 16) ; "The wake from the ship pushes Adam back where he started."
				(self dispose:)
			)
		)
	)
)

(instance boyLosesBalloons of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 20)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 4 1 self) ; Adam, "Oh, aaagh. Look at all this putrid stuff!"
			)
			(2
				((ScriptID 2 0) init: 3 0 0 6 1 self) ; Delphineus, "That's why they call it bilge. It's all their garbage, everything, and I do mean everything."
			)
			(3
				(= seconds 3)
			)
			(4
				((ScriptID 2 1) init: 2 0 0 5 1 self) ; Adam, "Hey, look at that kid, he's about to lose control of the balloons!"
			)
			(5
				(= seconds 2)
			)
			(6
				((ScriptID 2 1) init: 2 0 0 6 1 self) ; Adam, "HEY, KID, LOOK OUT!...The wind's too strong - he's gonna let go."
			)
			(7
				(boy cel: 0 setCycle: CT (Random 1 3) 1 self)
			)
			(8
				(if (< (++ local0) 4)
					(-= state 2)
					(boy setCycle: CT 0 -1 self)
				else
					(boy setCycle: CT 4 1 self)
				)
			)
			(9
				(boy setCycle: End)
				(balloons init: setMotion: MoveTo 216 11 self)
			)
			(10
				((ScriptID 2 0) init: 3 0 0 7 1 self) ; Delphineus, "Oh, no, the wind was too strong! Those babies were filled with helium, too. They can drift hundreds of miles till they sink."
			)
			(11
				(balloons setStep: 5 5 setMotion: MoveTo 230 -6 self)
			)
			(12
				(boy stopUpd:)
				(balloons dispose:)
				(if (not (IsFlag 15))
					(gDelph talkScript: trashbagTalk)
				)
				(SetFlag 62)
				(= local4 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance trashbagTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 1) init: 2 0 0 3 1 self) ; Adam, "Yech, look at all this junk! I don't think we can go any further. Wish I had my garbage bag."
			)
			(1
				((ScriptID 2 0) init: 3 0 0 5 1 self) ; Delphineus, "I guess we'd better backtrack, huh?"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance nobagTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Narrator init: 1 0 0 15 self) ; "Yech. Adam doesn't want to touch the garbage. It ought to go in his garbage bag."
			)
			(1
				((ScriptID 2 1) init: 2 0 0 1 1 self) ; Adam, "Ugh, what a time to forget my garbage bag!"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance island of PicView
	(properties
		x 148
		y 58
		lookStr 22
		view 322
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 19) ; "The island doesn't hold Adam's interest. Delphineus is beginning to look impatient."
			)
			(1 ; Walk
				(Narrator init: 1 0 0 18) ; "The island has been deserted for a long time. There's nothing interesting about it."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(water lookStr: 20)
	)
)

(instance shipATP of PicView
	(properties
		x 167
		y 88
		lookStr 8
		view 327
		signal 4096
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Narrator init: 1 0 0 26) ; "Getting that close to the ship could be dangerous."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance spew of Prop
	(properties
		x 192
		y 96
		z 20
		lookStr 7
		view 327
		loop 1
		priority 6
		signal 16
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 1 0 0 25) ; "That would be like emptying the ocean with a thimble. The bilge is flowing too fast for Adam to control."
			)
			(3 ; Do
				(Narrator init: 1 0 0 30) ; "The bilge is flowing fast enough to be dangerous. Adam shouldn't get any closer."
			)
			(4 ; Inventory
				(if (== theVerb 3) ; Do
					(Narrator init: 1 0 0 38) ; "That small flask of fertilizer solution wouldn't even make a dent in the ship's bilge. Adam decides to save it for something he CAN really make a difference on."
				else
					(Narrator init: 1 0 0 30) ; "The bilge is flowing fast enough to be dangerous. Adam shouldn't get any closer."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance junkPlume of PicView
	(properties
		x 192
		y 76
		lookStr 8
		view 327
		loop 2
		priority 8
		signal 4112
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 1 0 0 6) ; "The garbage flowing from the ship forms a gigantic mass. It would take Adam all day to clear it."
			)
			(3 ; Do
				(Narrator init: 1 0 0 6) ; "The garbage flowing from the ship forms a gigantic mass. It would take Adam all day to clear it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance shipFlags1 of Prop
	(properties
		x 139
		y 7
		view 327
		loop 3
		signal 28672
	)
)

(instance shipFlags2 of Prop
	(properties
		x 138
		y 8
		view 327
		loop 9
		cel 3
		signal 28672
	)
)

(instance shipFlags3 of Prop
	(properties
		x 255
		y 7
		view 327
		loop 10
		signal 28672
	)
)

(instance boy of Prop
	(properties
		x 187
		y 40
		view 327
		loop 6
		signal 24576
		cycleSpeed 20
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (>= cel 5)
					(Narrator init: 1 0 0 31) ; "The boy has lost his balloons. He's standing forlornly at the ship's rail."
				else
					(Narrator init: 1 0 0 35) ; "A boy is standing at the railing holding some helium-filled balloons."
				)
			)
			(3 ; Do
				(Narrator init: 1 0 0 32) ; "The boy is too far away."
			)
			(5 ; Talk
				(Narrator init: 1 0 0 33) ; "The boy can't hear Adam."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance jar of View
	(properties
		x 35
		y 167
		lookStr 5
		view 327
		loop 7
	)

	(method (doVerb theVerb invItem)
		(if (OneOf theVerb 3 10) ; Do, Recycle
			(gCurRoom setScript: getJunk self theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance balloons of Actor
	(properties
		x 198
		y 37
		view 327
		loop 8
		signal 26624
		xStep 2
		moveSpeed 12
	)
)

(instance j1 of PicView
	(properties
		x 52
		y 120
		lookStr 13
		view 327
		loop 4
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 1 0 0 30) ; "The bilge is flowing fast enough to be dangerous. Adam shouldn't get any closer."
			)
			(3 ; Do
				(if (IsFlag 15)
					(Narrator init: 1 0 0 30) ; "The bilge is flowing fast enough to be dangerous. Adam shouldn't get any closer."
				else
					(Narrator init: 6)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance j2 of PicView
	(properties
		x 160
		y 100
		view 327
		loop 4
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j3 of PicView
	(properties
		x 61
		y 116
		view 327
		loop 4
		cel 1
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j4 of PicView
	(properties
		x 4
		y 121
		view 327
		loop 4
		cel 2
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j5 of PicView
	(properties
		x 62
		y 112
		view 327
		loop 5
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j6 of PicView
	(properties
		x 14
		y 109
		view 327
		loop 5
		cel 1
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j7 of PicView
	(properties
		x 78
		y 115
		view 327
		loop 5
		cel 2
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j9 of PicView
	(properties
		x 52
		y 112
		view 327
		loop 5
		cel 4
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j10 of PicView
	(properties
		x 11
		y 115
		view 327
		loop 5
		cel 5
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j11 of PicView
	(properties
		x 44
		y 110
		view 327
		loop 5
		cel 6
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j12 of PicView
	(properties
		x 19
		y 113
		view 327
		loop 5
		cel 7
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j13 of PicView
	(properties
		x 46
		y 104
		view 327
		loop 5
		cel 8
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j14 of PicView
	(properties
		x 38
		y 114
		view 327
		loop 5
		cel 9
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(instance j16 of PicView
	(properties
		x 83
		y 118
		view 327
		loop 5
		cel 11
		signal 16384
	)

	(method (doVerb)
		(j1 doVerb: &rest)
	)
)

(class FloatingJunk of View
	(properties
		lookStr 13
		blockedBy 0
		controlBlock 0
	)

	(method (init)
		(if (not (& global116 controlBlock))
			(super init: &rest)
			(gEgo observeControl: controlBlock)
			(self stopUpd:)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Recycle
				(if (& blockedBy (gEgo illegalBits:))
					(Narrator init: 1 0 0 27) ; "Adam can't get to that piece yet. There's still too much stuff in the way."
				else
					(|= global116 controlBlock)
					(gCurRoom setScript: getJunk self)
				)
			)
			(3 ; Do
				(if (IsFlag 15)
					(Narrator init: 1 0 0 15) ; "Yech. Adam doesn't want to touch the garbage. It ought to go in his garbage bag."
				else
					(gCurRoom setScript: nobagTalk)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance getJunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local1 (gEgo illegalBits:))
				(gEgo illegalBits: 0 ignoreActors: 1)
				(if (< (gEgo x:) 110)
					(gEgo setCycle: 0 view: 818 setCycle: Fwd)
				)
				(= cycles 4)
			)
			(1
				(if (< (gEgo x:) 110)
					(gEgo
						setMotion: MoveTo (+ (caller x:) 18) (caller y:) self
					)
				else
					(gEgo setMotion: MoveTo 100 (caller y:) self)
				)
			)
			(2
				(= cycles 40)
			)
			(3
				(gEgo
					setCycle: 0
					view: 818
					setCycle: Fwd
					setMotion: MoveTo (+ (caller x:) 8) (caller y:) self
				)
			)
			(4
				(if (== caller jar)
					(gEgo get: 23) ; jar
					(SetScore 2 248)
				)
				(caller dispose:)
				(= cycles 30)
			)
			(5
				(gEgo ignoreActors: 0 illegalBits: local1)
				(cond
					((!= caller jar)
						(SetScore 5 247)
						(gEgo ignoreControl: (caller controlBlock:))
						(cond
							((not (IsFlag 123))
								(SetFlag 123)
								(Narrator init: 1 0 0 12 self) ; "Adam puts an item in his garbage bag. The water is a bit clearer."
							)
							((and (caller blockedBy:) (not (IsFlag 137)))
								(SetFlag 137)
								(Narrator init: 1 0 0 29 self) ; "Adam has cleared a narrow path through the garbage."
							)
							(else
								(= ticks 1)
							)
						)
					)
					((== register 10)
						(Narrator init: 1 0 0 4 self store: 11) ; "Adam decides not to throw out the jar. It looks recyclable."
					)
					(else
						(Narrator init: 1 0 0 11 self) ; "Adam picks up the glass jar and stows it away in his pack."
					)
				)
			)
			(6
				(HandsOn)
				(self caller: 0)
				(self dispose:)
			)
		)
	)
)

(instance j17 of FloatingJunk
	(properties
		x 35
		y 126
		view 327
		loop 5
		cel 10
		signal 16384
		controlBlock 8192
	)
)

(instance j18 of FloatingJunk
	(properties
		x 20
		y 125
		view 327
		loop 5
		cel 3
		signal 16384
		blockedBy 8192
		controlBlock 16384
	)
)

(instance j19 of FloatingJunk
	(properties
		x 10
		y 136
		view 327
		loop 4
		cel 2
		signal 16384
		blockedBy 2048
		controlBlock 4096
	)
)

(instance j20 of FloatingJunk
	(properties
		x 9
		y 142
		view 327
		loop 5
		cel 10
		signal 16384
		blockedBy 512
		controlBlock 1024
	)
)

(instance j21 of FloatingJunk
	(properties
		x 9
		y 151
		view 327
		loop 4
		signal 16384
		blockedBy -32768
		controlBlock 256
	)
)

(instance j22 of FloatingJunk
	(properties
		x 22
		y 135
		view 327
		loop 5
		cel 5
		signal 16384
		controlBlock 2048
	)
)

(instance j23 of FloatingJunk
	(properties
		x 3
		y 167
		view 327
		loop 5
		cel 13
		signal 16384
		blockedBy 2
		controlBlock 64
	)
)

(instance j24 of FloatingJunk
	(properties
		x 9
		y 173
		view 327
		loop 5
		cel 7
		signal 16384
		blockedBy 2
		controlBlock 32
	)
)

(instance j25 of FloatingJunk
	(properties
		x 22
		y 174
		view 327
		loop 5
		signal 16384
		controlBlock 2
	)
)

(instance j26 of FloatingJunk
	(properties
		x 28
		y 185
		view 327
		loop 5
		cel 1
		signal 16384
		controlBlock 8
	)
)

(instance j27 of FloatingJunk
	(properties
		x 9
		y 185
		view 327
		loop 5
		cel 4
		signal 16384
		blockedBy 8
		controlBlock 16
	)
)

(instance j28 of FloatingJunk
	(properties
		x 8
		y 160
		view 327
		loop 5
		cel 8
		signal 16384
		blockedBy -32768
		controlBlock 128
	)
)

(instance j29 of FloatingJunk
	(properties
		x 25
		y 144
		view 327
		loop 5
		cel 12
		signal 16384
		controlBlock 512
	)
)

(instance j30 of FloatingJunk
	(properties
		x 27
		y 156
		view 327
		loop 5
		cel 15
		signal 16384
		controlBlock -32768
	)
)

(instance sky of Feature
	(properties
		lookStr 9
	)

	(method (onMe param1)
		(return (< (param1 y:) 56))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 68)
					(Narrator init: 1 0 0 2 0 320) ; "A sunny tropical sky reflects the blue of the water."
				else
					(Narrator init: 1 0 0 9) ; "It's a bright, sunny day that gives Adam a perfect view of... the garbage."
				)
			)
			(3 ; Do
				(Narrator init: 1 0 0 37) ; "Adam can't fly."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance water of Feature
	(properties
		lookStr 10
	)

	(method (onMe)
		(return 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Recycle
				(Narrator init: 1 0 0 34) ; "Hey, it's a trash bag, not a water bottle!"
			)
			(3 ; Do
				(Narrator init: 1 0 0 36) ; "No use diving here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dive of Feature
	(properties
		nsTop 114
		nsLeft 100
		nsBottom 162
		nsRight 227
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(gEgo setScript: diveWithoutTanksOn)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance diveWithoutTanksOn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setCycle: 0
					view: 821
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo hide:)
				(= seconds 2)
			)
			(2
				(gEgo show: view: 821 setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(= cycles 14)
			)
			(4
				(if local3
					(Narrator init: 1 0 0 24 self) ; "Adam needs to put on his aqualung before diving!"
				else
					(= local3 1)
					(Narrator init: 1 0 0 23 self) ; "Adam's lungs couldn't hold out long enough. He needs to get ready before diving!"
				)
			)
			(5
				(gEgo view: 818)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

