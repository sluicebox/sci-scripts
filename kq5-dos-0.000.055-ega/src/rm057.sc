;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use Interface)
(use castle)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm057 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 36] = [104 189 103 178 3 179 77 160 87 150 92 140 172 137 171 141 111 142 120 150 143 155 212 150 212 145 265 146 319 136 319 0 0 0 0 189]
	[local43 22] = [319 147 271 147 267 149 278 160 302 170 265 179 223 175 158 179 165 186 182 189 319 189]
	[local65 40] = [104 189 103 178 3 179 77 160 99 163 105 148 85 147 92 140 172 137 171 141 111 142 120 150 143 155 212 150 212 145 265 146 319 136 319 0 0 0 0 189]
)

(instance rm057 of Rm
	(properties
		picture 57
		south 56
	)

	(method (init)
		(super init:)
		(self setRegions: 550) ; castle
		(Load rsVIEW 690)
		(Load rsVIEW 686)
		(Load rsVIEW 688)
		(= global357 249)
		(= global358 147)
		(= global355 46)
		(= global356 163)
		(gEgo init: yStep: 3 offset: 3)
		((gEgo head:)
			x: (gEgo x:)
			y: (gEgo y:)
			z: (CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
			moveHead: 1
			show:
		)
		(princess
			setPri: 11
			setLoop: 0
			setCycle: Fwd
			cycleSpeed: 3
			posn: 70 152
			init:
			ignoreActors: 1
		)
		(if (IsFlag 92)
			(= local5 1)
		)
		(switch gPrevRoomNum
			(south
				(gCurRoom setScript: enterSouth)
			)
			(96
				(gEgo put: 25 57 posn: 112 153 setLoop: 1 setCel: 1) ; Locket
				(princess
					setLoop: 4
					setCel: 255
					posn: 80 151
					setScript: afterCloseUp
				)
			)
			(else
				(gCurRoom setScript: enterEast)
			)
		)
		(fireplace cycleSpeed: 8 setCycle: (if (> global81 1) Fwd else 0) init:)
		(poly1 points: @local7 size: 18)
		(poly2 points: @local43 size: 11)
		(poly3 points: @local65 size: 20)
		(if (== ((gInventory at: 25) owner:) 57) ; Locket
			(self
				setFeatures: doorWay1 doorWay2 interior
				addObstacle: poly2 poly3
			)
		else
			(self
				setFeatures: doorWay1 doorWay2 interior
				addObstacle: poly1 poly2
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((and (gEgo inRect: 59 163 185 193) (== global331 3))
				(= global349 238)
				(= global350 153)
				(= global351 225)
				(= global354 135)
				((ScriptID 550 7) init: setScript: (ScriptID 550 12)) ; theWizard, theWizardScript
			)
			(
				(and
					(not (== (princess loop:) 1))
					(not (princess script:))
					(== global331 4)
				)
				(princess setScript: goBack)
			)
			(
				(and
					(< (gEgo distanceTo: princess) 60)
					(< (gEgo y:) 175)
					(not (== (princess loop:) 1))
					(not (== ((gInventory at: 25) owner:) 57)) ; Locket
					(not (princess script:))
				)
				(if (not local0)
					(princess setScript: scaredTalk)
				else
					(princess setLoop: 1 cel: 0 setCycle: End)
				)
			)
			(
				(and
					(> (gEgo distanceTo: princess) 80)
					(== (princess loop:) 1)
					(not (princess script:))
				)
				(princess setScript: scrubFloor)
			)
			((gEgo inRect: 256 140 281 148)
				(proc550_17)
				(gEgo illegalBits: 0 setScript: 0)
				(princess setScript: 0)
				(gCurRoom setScript: exitEast)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(proc550_17)
				(gEgo illegalBits: 0 setScript: 0)
				(princess setScript: 0)
				(gCurRoom setScript: exitSouth)
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
		(super dispose:)
	)
)

(instance giveLocketScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc550_17)
				(SetScore 4)
				(gGlobalSound number: 103 loop: -1 playBed:)
				(SetFlag 65)
				(= local3 (gEgo view:))
				(= local4 (gEgo cycleSpeed:))
				(gEgo
					put: 25 57 ; Locket
					illegalBits: 0
					setMotion: PolyPath 108 153 self
				)
			)
			(1
				(if (!= (princess loop:) 1)
					(princess cycleSpeed: 1 setLoop: 1 cel: 0 setCycle: End)
				)
				(gEgo setMotion: PolyPath 98 153 self)
			)
			(2
				((gEgo head:) hide:)
				(egoBody init: posn: (gEgo x:) (gEgo y:))
				(proc550_19)
				(gEgo
					normal: 0
					view: 690
					posn: (+ (gEgo x:) 2) (- (gEgo y:) 37)
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo cel: 0 setLoop: 1 setCycle: End self)
			)
			(4
				(princess cycleSpeed: 2 setLoop: 2 cel: 0 setCycle: End self)
			)
			(5
				(princess setLoop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(6
				(gEgo cel: 0 setLoop: 2 setCycle: End self)
				(princess setCel: 255)
			)
			(7
				(princess setLoop: 4 cel: 0 setCycle: End self)
			)
			(8
				(gEgo
					normal: 1
					view: local3
					cycleSpeed: local4
					setCycle: Walk
					setStep: 3 2
					setLoop: 5
				)
				((gEgo head:) show:)
				(= cycles 1)
			)
			(9
				(gCurRoom newRoom: 96)
			)
		)
	)
)

(instance scrubFloor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(princess setCycle: Beg self)
			)
			(1
				(princess setLoop: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(client setScript: 0 cue:)
			)
		)
	)
)

(instance goBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(princess setLoop: 1 cel: 0 setCycle: End)
			)
		)
	)
)

(instance scaredTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo setMotion: 0)
				(gGlobalSound number: 102 loop: -1 playBed: self)
				(proc0_7 gEgo princess 5)
				(if (!= (princess loop:) 1)
					(princess setLoop: 1 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(Say 101 57 0 67 10 10 25 5) ; "Don't come near me! Leave me alone!"
				(Say 160 57 1 67 120 10 25 6) ; "I would never hurt you. I'd like to help you."
				(Say 101 57 2 67 10 10 25 5) ; "I don't believe you! You're probably one of...THEM!"
				(Say 160 57 3 67 120 10 25 5) ; "I'm not; believe me."
				(Say 101 57 4 67 10 10 25 6) ; "Just go away...pleasssee! I don't want to talk to you anymore."
				(= cycles 1)
			)
			(2
				(gGlobalSound fade: 0 100 1 1)
				(cls)
				(gGlobalSound number: 101 loop: -1 play:)
				(proc550_18)
				(= local0 1)
				(client setScript: 0)
			)
		)
	)
)

(instance friendTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc550_17)
				(gEgo setMotion: 0)
				(proc0_7 gEgo princess 5)
				(= cycles 2)
			)
			(1
				(Say 101 57 5 67 10 10 25 6) ; "By the way, who are you?"
				(Say 160 57 6 67 120 10 25 6) ; "I'm King Graham of Daventry."
				(Say 101 57 7 67 10 10 25 10) ; "I think I know where that is! It's very far from my home, though. Ohhhhhhh!"
				(Say 160 57 8 67 120 10 25 10) ; "Don't worry. Somehow...I'll get you home again. But first, I've got to save my family."
				(Say 101 57 9 67 10 10 25 10) ; "Yes, well...(sniff), I'll stand by you, King Graham. I'll help you if I can."
				(Say 160 57 10 67 120 10 25 6) ; "Thanks. I may need it."
				(Say 101 57 11 67 10 10 25 10) ; "Well, I'd better get back to work. And you should keep out of sight!"
				(Say 160 57 12 67 120 10 25 6) ; "Aye, aye, m'lady."
				(= seconds 2)
			)
			(2
				(cls)
				(proc550_18)
				(if (!= (princess loop:) 0)
					(princess
						setLoop: 8
						setCel: 0
						ignoreActors: 1
						cycleSpeed: 3
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(princess setLoop: 0 posn: 70 152 setScript: scrubFloor)
				(client setScript: 0)
			)
		)
	)
)

(instance enterEast of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gGlobalSound number: 101 loop: -1 play:)
				(gEgo
					setPri: 10
					posn: 309 141
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 244 151 self
					setLoop: 1
				)
			)
			(1
				(proc550_18)
				(client setScript: 0)
			)
		)
	)
)

(instance princessHead of Prop
	(properties
		view 688
		loop 7
		signal 26624
	)
)

(instance egoBody of Prop
	(properties
		view 690
		loop 3
		signal 26624
	)
)

(instance candles of Prop ; UNUSED
	(properties
		y 72
		x 165
		view 686
		loop 1
	)
)

(instance fireplace of Prop
	(properties
		y 131
		x 134
		view 686
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 57 13) ; "A fire burns hotly in the fireplace while something in the iron pot boils above it."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not local2)
						(++ local2)
						(PrintDC 57 14) ; "The stuff boiling in the pot doesn't look, or smell, too appetizing."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance interior of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 57 15) ; "Graham surveys the kitchen in Mordack's castle in disgust. It is an untidy mishmash of dirty pots, jars with unidentified contents, rags, and assorted junk. Graham can see nothing that interests him."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance enterSouth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gGlobalSound number: 101 loop: -1 play:)
				(gEgo loop: 3 posn: 138 243 setMotion: MoveTo 138 186 self)
			)
			(1
				(proc550_18)
				(client setScript: 0)
			)
		)
	)
)

(instance princess of Act
	(properties
		view 688
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(if (== ((gInventory at: 25) owner:) 57) ; Locket
						(PrintDC 57 16) ; "Princess Cassima (whom Graham now knows to have been stolen by Mordack from the Kingdom of the Green Isles), looks pleased to see him. She smiles in friendship."
					else
						(switch (princess loop:)
							(0
								(PrintDC 57 17) ; "A lovely young girl with long black hair, olive skin, and flashing green eyes laboriously scrubs the cold stone floor. Though wearing rags, her beauty nevertheless shines through."
							)
							(1
								(PrintDC 57 18) ; "A lovely young girl with long black hair, olive skin, and flashing green eyes cowers, frightened, in the corner of the kitchen. Though wearing rags, her beauty nevertheless shines through."
							)
						)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (== ((gInventory at: 25) owner:) 57) ; Locket
						(PrintDC 57 19) ; "Princess Cassima looks glad to see Graham. Perhaps she feels he can help to get her off of this horrible island."
					else
						(switch (princess loop:)
							(0
								(PrintDC 57 20) ; "The young girl endlessly scrubs the hard floor. She doesn't pay any attention to Graham."
							)
							(1
								(PrintDC 57 21) ; "The poor girl cowers in the corner. It doesn't appear that she trusts Graham."
							)
						)
					)
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(25 ; Locket
							(gCurRoom setScript: giveLocketScript)
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(if (== ((gInventory at: 25) owner:) 57) ; Locket
								(PrintDC 57 22) ; "That won't help Princess Cassima in any way."
							else
								(gCurRoom setScript: noThanks)
							)
							(event claimed: 1)
						)
					)
				)
				(4 ; Talk
					(if (not (princess script:))
						(if (== ((gInventory at: 25) owner:) 57) ; Locket
							(switch (++ local5)
								(1
									(event claimed: 1)
									(SetFlag 92)
									(princess setScript: friendTalk)
								)
								(2
									(PrintDC 57 23) ; "While Princess Cassima busily scrubs the kitchen floor Graham tries to figure out what to do next."
									(event claimed: 1)
								)
								(else
									(event claimed: 0)
								)
							)
						else
							(++ local5)
							(if (and local0 (== local5 1))
								(= local5 2)
							)
							(switch local5
								(1
									(event claimed: 1)
									(gEgo setMotion: 0)
									(princess setScript: scaredTalk)
								)
								(else
									(PrintDC 57 24) ; "Since the girl seems so frightened, Graham compassionately decides to leave her alone for now."
									(event claimed: 1)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance blockOne of Blk ; UNUSED
	(properties
		top 137
		bottom 159
		right 80
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

(instance exitSouth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 138 243 self)
			)
			(1
				(gGlobalSound fade:)
				(gCurRoom newRoom: 56)
			)
		)
	)
)

(instance exitEast of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(gGlobalSound fade:)
				(gEgo illegalBits: 0 setMotion: MoveTo 309 141 self)
			)
			(1
				(gCurRoom newRoom: 58)
			)
		)
	)
)

(instance egoHeadMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) loop: (Random 4 6))
				(-- state)
				(= cycles 3)
			)
		)
	)
)

(instance afterCloseUp of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(= cycles 2)
			)
			(1
				((gEgo head:) setCel: 5 moveHead: 0)
				(princess setLoop: 5 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(2
				((gEgo head:) setScript: egoHeadMove)
				(PrintDC 57 25 #at 100 20 #dispose) ; "Don't worry. I'm here to save my family from the wizard. He's got them here someplace imprisoned inside a glass bottle. If I can manage to rescue them then I won't forget you, either."
				(= seconds 10)
			)
			(3
				((gEgo head:) setScript: 0)
				(princessHead
					x: (+ (princess x:) 1)
					y: (princess y:)
					z: 33
					cycleSpeed: 2
					setCycle: Fwd
					init:
				)
				(PrintDC 57 26 #at 20 20 #dispose) ; "I know the glass bottle you're talking about! It's in Mordack's laboratory upstairs!"
				(= seconds 6)
			)
			(4
				(princessHead hide:)
				((gEgo head:) setScript: egoHeadMove)
				(PrintDC 57 27 #dispose #at 100 20) ; "Keep quiet about my presence. I think this will be the most difficult part of my journey. I may not...survive it."
				(= seconds 6)
			)
			(5
				((gEgo head:) setScript: 0)
				(princessHead show:)
				(PrintDC 57 28 #dispose #at 20 20) ; "I would NEVER give you away. And I will help you in any way I can, kind sir."
				(gGlobalSound fade:)
				(= seconds 6)
			)
			(6
				(princessHead dispose:)
				(cls)
				(proc550_18)
				((gEgo head:) setCel: -1 setLoop: 4 moveHead: 1)
				(ClearFlag 65)
				(gGlobalSound number: 101 loop: -1 play:)
				(client setScript: 0)
			)
		)
	)
)

(instance doorWay1 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $4000))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 57 29) ; "The doorway goes into a hallway containing an unusual pipe organ."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance doorWay2 of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0400))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 57 30) ; "This doorway leads into the pantry."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance noThanks of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc550_17)
				(if (< (gEgo x:) 82)
					(gEgo setMotion: PolyPath 114 161 self)
				else
					(self cue:)
				)
			)
			(1
				(proc0_7 gEgo princess 5)
				(if (!= (princess loop:) 1)
					(princess setLoop: 1 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(Say 101 57 31 67 10 10 25 5) ; "Take that away from me! I don't want it!"
				(= seconds 1)
			)
			(3
				(if (> (gEgo distanceTo: princess) 80)
					(princess setScript: scrubFloor)
				)
				(proc550_18)
				(client setScript: 0)
			)
		)
	)
)

