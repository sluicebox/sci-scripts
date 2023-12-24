;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	rm350 0
)

(local
	[unused 3]
	[closePts 28] = [319 0 319 189 314 189 314 159 296 154 253 154 234 148 234 139 213 133 81 133 3 153 3 189 0 189 0 0]
	[openPts 34] = [262 0 262 151 237 151 237 139 213 133 81 133 3 153 3 184 315 184 314 158 293 152 273 151 273 0 319 0 319 189 0 189 0 0]
	[middlePts 28] = [85 144 108 137 149 137 149 146 161 146 161 137 205 137 222 145 213 155 229 157 224 172 181 172 179 160 85 160]
)

(class ElevatorNumbers of View
	(properties
		y 180
		description {the button}
		view 333
		loop 1
		priority 15
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setLoop: (+ (self loop:) 1))
				(Animate (gCast elements:) 0)
				(if (== (= gFloorTo (self cel:)) 8)
					(HandsOff)
					(self setLoop: (- (self loop:) 1))
					(Animate (gCast elements:) 0)
					(gCurRoom setScript: sNoRide)
				else
					(HandsOff)
					(gCurRoom setScript: sToElevator)
				)
			)
			(5 ; Talk
				(gCurRoom doVerb: 5)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance rm350 of LLRoom
	(properties
		picture 350
	)

	(method (init)
		(LoadMany rsVIEW 350 808 333 331 332)
		(LoadMany rsSOUND 350 340 351 353)
		(gTheMusic3 loop: 1 vol: 127 flags: 1)
		(closeObstacle points: @closePts size: 14)
		(openObstacle points: @openPts size: 19)
		(middleObstacle points: @middlePts size: 14)
		(closeObstacles add: middleObstacle closeObstacle)
		(openObstacles add: middleObstacle openObstacle)
		(gCurRoom obstacles: closeObstacles)
		(gEgo init:)
		(super init:)
		(if (!= gPrevRoomNum 355)
			(gTheMusic number: 351 loop: -1 vol: 127 flags: 1 play:)
		)
		(doors cycleSpeed: (+ gHowFast 1) init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(elevator
			cycleSpeed: (+ gHowFast 1)
			moveSpeed: (+ gHowFast 1)
			init:
			approachVerbs: 3 4 10 11 ; Do, Inventory, Zipper, Taste/Smell
		)
		(deskF init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(if (not (IsFlag 9)) ; fFaithGone
			(LoadMany rsVIEW 352)
			(faith
				cycleSpeed: gHowFast
				moveSpeed: gHowFast
				init:
				stopUpd:
				approachVerbs: 3 4 10 11 5 2 ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
			)
		else
			(deskF
				lookStr:
					{Now that you're no longer staring at Faith's ample weapons, you notice an unlabeled button on her desk.}
			)
		)
		(switch gPrevRoomNum
			(360
				(elevator stopUpd:)
				(gEgo x: 400)
				(HandsOff)
				(gCurRoom setScript: sFromPenthouse)
			)
			(340
				(doors stopUpd:)
				(HandsOff)
				(gCurRoom setScript: sFromElevator)
			)
			(355
				(elevator stopUpd:)
				(gEgo loop: 1 show: normal: 1 setMotion: 0)
				(if (ObjInRoom 15)
					(LoadMany rsSOUND 353)
					(gCurRoom setScript: sFaithLeaves)
				)
			)
			(else
				(gEgo posn: 160 170)
			)
		)
		(plants init:)
		(door1 init:)
		(door2 init:)
		(door3 init:)
		(door4 init:)
		(sculpture init:)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (gEgo mover:) (gCast contains: numberPad))
			(numberPad dispose:)
			(gEgo illegalBits: -32768)
			(gCast eachElementDo: #perform disposeNumbers)
			(if (== (gCurRoom script:) sElevatorScript)
				(gCurRoom setScript: 0)
			)
		)
		(cond
			(script)
			((SteppedOn gEgo 2)
				(HandsOff)
				(gCurRoom setScript: sToPenthouse)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 9) ; fFaithGone
					(Print 350 0) ; "You are at the top floor of the hotel. That desk is where you lost your Faith, remember?"
					(Print 350 1 #at -1 140) ; "(Al's so proud he finally got to use THAT line!)"
				else
					(Print 350 2) ; "You are at the top floor of the hotel. A beautiful security guard sits behind a desk."
				)
			)
			(5 ; Talk
				(Print 350 3) ; "strangers in the night, da da da dee da..."
				(Print 350 4 #at -1 140) ; "(How you love Muzak!)"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (dispose)
		(closeObstacles dispose:)
		(openObstacles dispose:)
		(super dispose:)
	)
)

(instance sFromElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(elevator
					view: 331
					y: 190
					setCycle: Fwd
					setMotion: MoveTo (elevator x:) 137 self
				)
			)
			(1
				(elevator setCycle: End self)
			)
			(2
				(gTheMusic3 number: 340 play:)
				(gEgo x: 156 y: 137 z: 0 show:)
				(NormalEgo 2)
				(elevator view: 332 stopUpd:)
				(if (not (IsFlag 97)) ; fGotDizzy
					(SetFlag 97) ; fGotDizzy
					(Print 350 5) ; "Whew! You're dizzy."
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sToElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(numberPad dispose:)
				(gCast eachElementDo: #perform disposeNumbers)
				(= cycles 30)
			)
			(2
				(gEgo z: 1000 hide: normal: 0)
				(elevator
					view: 331
					cel: 0
					setCycle: Rev
					setMotion: MoveTo (elevator x:) 190 self
				)
			)
			(3
				(gTheMusic fade:)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance sElevatorScript of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (gEgo mover:)
			(numberPad dispose:)
			(gCast eachElementDo: #perform disposeNumbers)
			(self dispose:)
		)
	)

	(method (changeState newState &tmp i j)
		(switch (= state newState)
			(0
				(numberPad init:)
				(for ((= i 0)) (< i 4) ((++ i))
					(for ((= j 0)) (< j 2) ((++ j))
						((aNumber new:)
							init:
							z: (+ 84 (* i 18))
							x: (+ 240 (* j 43))
							cel: (+ 1 (* i 2) j)
						)
					)
				)
			)
		)
	)
)

(instance sFaithLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(gTheMusic number: 353 loop: 1 play:)
				(employeeExit init:)
				(Print 350 6) ; "I'm outta here!" cries Faith. "I've gotta get home to my boyfriend before this stuff wears off!"
				(faith
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 5 185 self
				)
			)
			(2
				(Print 350 7) ; "Hey, thanks a lot, buddy!" shouts Faith across the hotel. "We'll do it once for you!"
				(Print 350 8) ; "Twisting her key in the lock, she disappears down the unmarked employee staircase."
				(faith setMotion: MoveTo -40 185 self)
			)
			(3
				(gTheMusic number: 351 loop: -1 play:)
				(Print 350 9) ; "Sorry, Larry. It appears Faith is true to her name."
				(SetFlag 9) ; fFaithGone
				(deskF
					lookStr:
						{Now that you're no longer staring at Faith's ample weapons, you notice an unlabeled button on her desk.}
				)
				(HandsOn)
				(self dispose:)
				(faith dispose:)
			)
		)
	)
)

(instance sToPenthouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: -32768 setMotion: MoveTo 267 149 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gTheMusic3 number: 350 play:)
				(gEgo illegalBits: 0 normal: 0 hide:)
				(doors setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gEgo illegalBits: -32768)
				(Print 350 10) ; "Oh, oh. Where are we goin' now, Larry?"
				(Points 50 5)
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance sFromPenthouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(gTheMusic3 number: 350 play:)
				(doors setLoop: 1 setCel: 5 setCycle: Beg self)
			)
			(2
				(gEgo x: 267 y: 149 illegalBits: 0)
				(= cycles 5)
			)
			(3
				(doors setLoop: 0 setCel: 5)
				(gEgo
					egoSpeed:
					show:
					normal: 1
					setMotion: MoveTo (- (gEgo x:) 10) (+ (gEgo y:) 5)
				)
				(= cycles 5)
			)
			(4
				(gTheMusic3 number: 350 play:)
				(doors setCycle: Beg doors)
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 10)
						(+ (gEgo y:) 5)
						self
				)
			)
			(5
				(NormalEgo 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sPushButton of Script
	(properties)

	(method (changeState newState &tmp [string 100])
		(switch (= state newState)
			(0
				(gEgo
					egoSpeed:
					view: 808
					loop: 1
					cel: 0
					setPri: (+ (gEgo priority:) 1)
					setCycle: End self
				)
			)
			(1
				(gTheMusic3 number: 350 play:)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print
					(Format ; "The penthouse elevator doors glide %s."
						@string
						350
						11
						(if register {open} else {close})
						(if register {abierto} else {cerrado})
					)
					#dispose
					#time
					5
					#at
					-1
					20
				)
				(if register
					(gCurRoom obstacles: openObstacles)
				else
					(gCurRoom obstacles: closeObstacles)
				)
				(doors setCycle: (if (doors cel:) Beg else End) doors)
				(gEgo setCycle: Beg self)
			)
			(2
				(NormalEgo 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sNoRide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(Print 350 12) ; "The rumors were right. You are quick on the trigger, Larry!"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance aNumber of ElevatorNumbers
	(properties
		description {the button}
	)
)

(instance disposeNumbers of Code
	(properties)

	(method (doit obj)
		(if (obj isKindOf: ElevatorNumbers)
			(obj dispose:)
		)
	)
)

(instance faith of Person
	(properties
		x 198
		y 166
		description {the security guard}
		sightAngle 40
		approachX 226
		approachY 167
		view 352
		loop 3
		signal 16384
		xStep 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(gCurRoom newRoom: 355)
			)
			(else
				(Print 350 13) ; "She might listen to you, if you can establish eye contact."
			)
		)
	)
)

(instance elevator of Actor
	(properties
		x 156
		y 137
		description {the elevator}
		sightAngle 40
		approachY 137
		yStep 12
		view 332
		priority 10
		signal 24592
	)

	(method (init)
		(self approachX: 155)
		(super init:)
	)

	(method (cue)
		(super cue:)
		(if (and (== (gEgo x:) 156) (== (gEgo y:) 137))
			(Print 350 14) ; "There are buttons labeled "one" through "eight.""
		else
			(Print 350 15) ; "The glass elevator only goes down from here. How about you?"
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gEgo
					setHeading:
						(GetAngle (gEgo x:) (gEgo y:) (self x:) (self y:))
						self
				)
			)
			(3 ; Do
				(gCurRoom setScript: sElevatorScript)
			)
			(5 ; Talk
				(gCurRoom doVerb: 5)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance numberPad of View
	(properties
		x 262
		y 170
		z 48
		description {the key pad}
		view 333
		priority 14
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gCurRoom doVerb: 2)
			)
			(5 ; Talk
				(gCurRoom doVerb: 5)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance doors of Prop
	(properties
		x 267
		y 154
		description {the doors}
		sightAngle 40
		approachX 267
		approachY 154
		view 350
		priority 10
		signal 16400
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (not (== (doors cel:) 5))
					(Print 350 16) ; "The doors are securely closed. A brass plate near the elevator says: "Private." There is no button nearby."
				else
					(Print 350 17) ; "The doors are open. Go on in."
				)
			)
			(3 ; Do
				(if (not (== (doors cel:) 5))
					(Print 350 16) ; "The doors are securely closed. A brass plate near the elevator says: "Private." There is no button nearby."
				else
					(HandsOff)
					(gCurRoom setScript: sToPenthouse)
				)
			)
			(5 ; Talk
				(gCurRoom doVerb: 5)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance deskF of Feature
	(properties
		x 203
		y 168
		nsTop 138
		nsLeft 193
		nsBottom 167
		nsRight 214
		description {the security desk}
		sightAngle 40
		approachX 226
		approachY 167
		lookStr {A beautiful security guard sits at the desk. A pair of large pistols are in a holster around her slim waist. She looks friendly, but quick on the trigger.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((not (IsFlag 9)) ; fFaithGone
						(Print 350 18) ; "Touch that button, and you're dead meat, White-Suit!"
					)
					((not (doors cel:))
						(HandsOff)
						(gCurRoom setScript: sPushButton 0 1)
					)
					(else
						(HandsOff)
						(gCurRoom setScript: sPushButton 0 0)
					)
				)
			)
			(5 ; Talk
				(gCurRoom doVerb: 5)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door1 of Feature
	(properties
		x 15
		y 116
		nsTop 97
		nsLeft 3
		nsBottom 138
		nsRight 27
		description {the door}
		lookStr {It's a door just like all the others.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 350 19) ; ""Hello? Hello?" you cry. There is no answer from within."
			)
			(3 ; Do
				(Print 350 20) ; "Evidently the rooms on this floor are all unoccupied."
			)
			(4 ; Inventory
				(Print 350 21) ; "It's no good. The door resists all of your efforts."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door2 of Feature
	(properties
		x 50
		y 116
		nsTop 98
		nsLeft 40
		nsBottom 134
		nsRight 60
		description {the door}
	)

	(method (doVerb theVerb invItem)
		(door1 doVerb: theVerb invItem)
	)
)

(instance door3 of Feature
	(properties
		x 102
		y 112
		nsTop 94
		nsLeft 90
		nsBottom 130
		nsRight 115
		description {the door}
	)

	(method (doVerb theVerb invItem)
		(door1 doVerb: theVerb invItem)
	)
)

(instance door4 of Feature
	(properties
		x 189
		y 120
		nsTop 95
		nsLeft 175
		nsBottom 126
		nsRight 203
		description {the door}
	)

	(method (doVerb theVerb invItem)
		(door1 doVerb: theVerb invItem)
	)
)

(instance plants of Feature
	(properties
		x 159
		y 143
		nsTop 130
		nsLeft 111
		nsBottom 156
		nsRight 207
		description {the plants}
		sightAngle 40
		lookStr {They almost look real, don't they?}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(gCurRoom doVerb: theVerb invItem)
			)
			(11 ; Taste/Smell
				(Print 350 22) ; "To you, the plants have no distinctive smell or taste."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance sculpture of Feature
	(properties
		x 155
		y 155
		z 120
		nsTop 4
		nsLeft 110
		nsBottom 67
		nsRight 201
		description {the sculpture}
		sightAngle 40
		lookStr {Atop the elevator shaft, a modern woman runs to meet her alien lover.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(gCurRoom doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance employeeExit of Feature
	(properties
		x 10
		y 166
		nsTop 144
		nsBottom 189
		nsRight 21
		description {the employee exit}
		sightAngle 40
		lookStr {Evidently, this exit is for employees only. You'd better use the elevator.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self doVerb: 2)
			)
			(5 ; Talk
				(gCurRoom doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance closeObstacles of List
	(properties)
)

(instance openObstacles of List
	(properties)
)

(instance middleObstacle of Polygon
	(properties
		type PBarredAccess
	)
)

(instance closeObstacle of Polygon
	(properties
		type PBarredAccess
	)
)

(instance openObstacle of Polygon
	(properties
		type PBarredAccess
	)
)

