;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 214)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm214 0
)

(local
	local0
	local1
	[local2 18] = [17 189 34 179 16 179 16 177 129 177 141 159 141 0 0 0 0 189]
	[local20 20] = [253 189 248 185 264 179 296 179 295 173 200 177 180 159 180 0 319 0 319 189]
)

(instance rm214 of Rm
	(properties
		picture 214
		south 213
	)

	(method (init)
		(super init:)
		(if (== ((gInventory at: 7) owner:) 214) ; Staff
			(brokenStaff init:)
		)
		(door init:)
		(switch gPrevRoomNum
			(213
				(if (and (not (IsFlag 33)) (IsFlag 53))
					(horseBody1 init:)
					(horseHead1 init: setScript: (tailSwish new:))
					(horseTail1
						ignoreActors: 1
						init:
						setScript: (tailSwish new:)
					)
					(horseBody2 init:)
					(guardHead2 init: setScript: (tailSwish new:))
					(horseHead2 init: setScript: tailSwish)
					(horseTail2
						ignoreActors: 1
						init:
						setScript: (tailSwish new:)
					)
					(self setScript: guardEnter)
				else
					(gEgo
						view: 2
						posn: 158 186
						offset: 2
						setStep: 2 1
						illegalBits: $8000
						observeControl: 16384
						offset: 3
						init:
					)
					(door setScript: musicScript)
				)
			)
			(18
				(HandsOff)
				(gEgo
					view: 2
					posn: 158 162
					offset: 2
					setStep: 2 1
					loop: 11
					cel: 2
					observeControl: 16384
					offset: 3
					init:
				)
				(door cel: (- (NumCels door) 1))
				(self setScript: exitTemple)
			)
			(else
				(gEgo
					view: 2
					posn: 158 162
					offset: 2
					setStep: 2 1
					illegalBits: $8000
					observeControl: 16384
					offset: 3
					init:
				)
			)
		)
		(self setFeatures: horse1 horse2 sands room)
		(poly1 points: @local2 size: 9)
		(poly2 points: @local20 size: 10)
		(self addObstacle: poly1 poly2)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
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

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gGlobalSound fade:)
		(gGlobalSound2 fade:)
	)

	(method (dispose)
		(gEgo ignoreControl: 16384)
		(super dispose:)
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 71))
					(SetFlag 71)
					(gGlobalSound number: 43 loop: 1 vol: 127 playBed: self)
				else
					(= cycles 1)
				)
			)
			(1
				(gGlobalSound number: 44 loop: -1 vol: 127 play:)
			)
		)
	)
)

(instance exitTemple of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound3 number: 18 loop: 1 vol: 127 play:)
				(door setCycle: Beg self)
			)
			(1
				(Print 214 0) ; "Whew! That was close!"
				(door stopUpd:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance knockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 158 162 self)
			)
			(1
				((gEgo head:) hide:)
				(if local1
					(gEgo
						normal: 0
						view: 362
						loop: 0
						cycleSpeed: 3
						cel: 0
						setCycle: End self
					)
				else
					(gEgo
						normal: 0
						view: 384
						loop: 0
						cel: 0
						setCycle: End self
					)
				)
			)
			(2
				(PrintDC 214 1 #at 20 20 #dispose) ; "Open sesame!"
				(if local1
					(gGlobalSound3 number: 53 loop: 2 vol: 127 play:)
					(gEgo loop: 1 cycleSpeed: 5 setCycle: Fwd)
					(= cycles 10)
				else
					(gGlobalSound3 number: 104 loop: 2 vol: 127 play:)
					(gEgo loop: 1 cycleSpeed: 3 setCycle: Fwd)
					(= seconds 2)
				)
			)
			(3
				(if local1
					(gEgo loop: 2 cel: 0 cycleSpeed: 3 setCycle: End self)
					(gGlobalSound3 number: 856 loop: 1 vol: 127 play:)
				else
					(gEgo loop: 0)
					(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
				)
			)
			(4
				(cls)
				(if local1
					(PrintDC 214 2 #at 10 10 #time 5) ; "Oh, no! The staff broke!"
					(brokenStaff init:)
					(gGlobalSound3 number: 18 loop: 1 vol: 127 play:)
					(door setCycle: End self)
				else
					(PrintDC 214 3) ; "The temple door won't open. Perhaps there's something missing...."
					(gEgo
						normal: 1
						view: 2
						loop: 7
						cel: 3
						cycleSpeed: 0
						setCycle: Walk
					)
					((gEgo head:) show:)
					(HandsOn)
					(client setScript: 0)
				)
			)
			(5
				(= seconds 3)
			)
			(6
				(gGlobalSound3 stop:)
				(= cycles 10)
			)
			(7
				(cls)
				(gCurRoom newRoom: 18)
			)
		)
	)
)

(instance tailSwish of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End)
				(= seconds (Random 2 4))
				(-- state)
			)
		)
	)
)

(instance guardEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 44 loop: -1 vol: 127 play:)
				(horseBody1 cycleSpeed: 3 setCycle: End self)
			)
			(1
				(guard1 init: cycleSpeed: 3 setCycle: End self)
				(horseBody1 loop: 4 ignoreActors: 1)
			)
			(2
				(guard1
					view: 370
					setCycle: Walk
					setLoop: 0
					cycleSpeed: 0
					moveSpeed: 1
					setMotion: MoveTo 160 185 self
				)
			)
			(3
				(guard1 setLoop: 2 setMotion: MoveTo 163 161 self)
			)
			(4
				(guard1 setLoop: 3 cycleSpeed: 3 cel: 0 setCycle: End self)
			)
			(5
				(PrintDC 214 1 #at 20 20 #dispose) ; "Open sesame!"
				(guard1 setLoop: 4 cycleSpeed: 5 setCycle: Fwd)
				(gGlobalSound3 number: 53 loop: 3 vol: 127 play:)
				(= cycles 18)
			)
			(6
				(gGlobalSound3 number: 18 loop: 1 vol: 127 play:)
				(door setCycle: End self)
			)
			(7
				(cls)
				(guard1 setLoop: 5 cel: 0 cycleSpeed: 3 setCycle: End self)
			)
			(8
				(= seconds 5)
			)
			(9
				(guard1 view: 372 setLoop: 0 cel: 0 setCycle: End self)
			)
			(10
				(gGlobalSound3 number: 18 loop: 1 vol: 127 play:)
				(door setCycle: Beg)
				(guard1
					setLoop: 1
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 160 184 self
				)
			)
			(11
				(guard1 setLoop: 3 setMotion: MoveTo 84 184 self)
			)
			(12
				(guard1 hide:)
				(horseBody1
					view: 368
					loop: 1
					cel: (- (NumCels guard1) 1)
					setCycle: Beg self
				)
			)
			(13
				(gCurRoom newRoom: 213)
			)
		)
	)
)

(instance sands of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 214 4) ; "Looking south, the desert seems to extend forever."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance horse1 of RFeature
	(properties
		nsTop 111
		nsBottom 175
		nsRight 37
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 214 5) ; "Stone statues of Pegasus guard the old, crumbling temple."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 214 6) ; "Graham examines the statue carefully but doesn't see anything interesting."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance horse2 of RFeature
	(properties
		nsTop 111
		nsLeft 257
		nsBottom 177
		nsRight 319
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 214 5) ; "Stone statues of Pegasus guard the old, crumbling temple."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 214 6) ; "Graham examines the statue carefully but doesn't see anything interesting."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance door of Prop
	(properties
		y 163
		x 161
		view 369
		priority 5
		signal 16401
		cycleSpeed 1
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 214 7) ; "Looming before him, the huge temple door beckons tantalizingly to Graham."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: knockDoor)
					(event claimed: 1)
				)
				(4 ; Talk
					(Say 160 214 1) ; "Open sesame!"
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(7 ; Staff
							(HandsOff)
							(= local1 1)
							(gEgo put: 7 214) ; Staff
							(SetScore 2)
							(gCurRoom setScript: knockDoor)
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 214 8) ; "It has no effect on the massive door."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 214 9) ; "Built into the rocky cliffs, an ancient temple towers above Graham as he surveys its ornately carved columns and friezes."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance guard1 of Act
	(properties
		y 184
		x 84
		view 368
		loop 7
	)
)

(instance horseBody1 of Prop
	(properties
		y 183
		x 66
		view 368
		loop 1
		priority 12
		signal 16
		cycleSpeed 2
	)
)

(instance horseHead1 of Prop
	(properties
		y 166
		x 64
		view 368
		loop 2
		cycleSpeed 4
	)
)

(instance horseTail1 of Prop
	(properties
		y 158
		x 93
		view 368
		loop 3
		cycleSpeed 2
	)
)

(instance horseBody2 of Prop
	(properties
		y 183
		x 223
		view 378
		loop 2
		priority 12
		signal 16
		cycleSpeed 2
	)
)

(instance horseHead2 of Prop
	(properties
		y 166
		x 214
		view 378
		loop 3
		priority 14
		signal 16
		cycleSpeed 4
	)
)

(instance horseTail2 of Prop
	(properties
		y 158
		x 243
		view 378
		loop 4
		cycleSpeed 2
	)
)

(instance guardHead2 of Prop
	(properties
		y 146
		x 222
		view 378
		loop 5
		priority 15
		signal 16
		cycleSpeed 1
	)
)

(instance brokenStaff of Prop
	(properties
		y 162
		x 169
		view 362
		loop 3
		priority 5
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 214 10) ; "The staff lies in several broken pieces on the temple steps."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 214 11) ; "The staff is broken and is of no use anymore."
					(event claimed: 1)
				)
			)
		)
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

