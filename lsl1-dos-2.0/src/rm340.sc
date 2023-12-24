;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
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
	rm340 0
)

(local
	floorWant
)

(procedure (FadeIt)
	(gTheIconBar disable:)
	(gCurRoom drawPic: (gCurRoom picture:))
	(floorNumber cel: gFloorTo)
	(if (== gFloorTo 4)
		(suiteDoor init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(if (gFeatures contains: door1)
			(door1 dispose:)
		)
		(theHeart z: 0)
	else
		(theHeart z: 1000)
		(door1 init:)
		(if (gFeatures contains: suiteDoor)
			(suiteDoor dispose:)
		)
	)
	(Animate (gCast elements:) 0)
	(gTheIconBar enable:)
)

(class ElevatorNumbers of View
	(properties
		y 180
		description {a button}
		view 333
		loop 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(self setLoop: (+ (self loop:) 1))
				(Animate (gCast elements:) 0)
				(= floorWant (self cel:))
				(if (== gFloorTo floorWant)
					(HandsOff)
					(self setLoop: (- (self loop:) 1))
					(Animate (gCast elements:) 0)
					(gCurRoom setScript: sNoRide)
				else
					(HandsOff)
					(gEgo illegalBits: 0)
					(if (> floorWant gFloorTo)
						(HandsOff)
						(gCurRoom setScript: sUpElevator)
					else
						(HandsOff)
						(gCurRoom setScript: sDownElevator)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance rm340 of LLRoom
	(properties
		picture 340
		style 30
	)

	(method (init)
		(if gDebugging
			(SetFlag 12) ; fFawnInRoom
			(gEgo get: 11) ; pocketKnife
		)
		(if (> gDebugging 1)
			(SetFlag 24) ; fOrderedWine
		)
		(LoadMany rsVIEW 340 332 333 331 808)
		(LoadMany rsSOUND 340 310 341)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 316 189 316 154 222 130 90 128 3 144 3 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 150 135 150 146 164 146 164 135 211 135 231 140 206 161 109 161 95 145 95 138 109 136
					yourself:
				)
		)
		(gTheMusic3 loop: 1 vol: 127 flags: 1)
		(switch gPrevRoomNum
			(330
				(floorNumber cel: 2)
				(if (== gFloorTo 2)
					(HandsOff)
					(self setScript: sArriveUp)
				else
					(= floorWant gFloorTo)
					(= gFloorTo 2)
					(HandsOff)
					(self setScript: sGoUp)
				)
			)
			(350
				(gTheMusic number: 310 loop: -1 flags: 1 play:)
				(floorNumber cel: 7)
				(if (== gFloorTo 7)
					(HandsOff)
					(self setScript: sArriveDown)
				else
					(= floorWant gFloorTo)
					(= gFloorTo 7)
					(HandsOff)
					(self setScript: sGoDown)
				)
			)
			(390
				(gTheMusic number: 310 loop: -1 flags: 1 play: 90)
				(floorNumber cel: 4)
				(gEgo x: 40 y: 138 loop: 0 normal: 0)
				(HandsOff)
				(elevator stopUpd:)
				(gCurRoom setScript: sFrom390)
			)
			(else
				(gEgo posn: 160 175)
				(= gFloorTo 4)
				(suiteDoor init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
				(theHeart z: 0)
			)
		)
		(gEgo init:)
		(super init:)
		(if (== gPrevRoomNum 390)
			(suiteDoor init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		else
			(door1 init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
			(theHeart z: 1000)
		)
		(elevator
			cycleSpeed: (+ global101 1)
			moveSpeed: (+ global101 1)
			init:
			approachVerbs: 3 4 10 11 ; Do, Inventory, Zipper, Taste/Smell
		)
		(floorNumber init:)
		(theHeart init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(door2 init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(door3 init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(door4 init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(door5 init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(door6 init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(ashtray init:)
		(plants init:)
		(elevatorShaft init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
	)

	(method (doit)
		(super doit: &rest)
		(if (gEgo mover:)
			(gEgo illegalBits: -32768)
			(if (gCast contains: numberPad)
				(numberPad dispose:)
				(gCast eachElementDo: #perform disposeNumbers)
				(if (== (gCurRoom script:) sElevatorScript)
					(gCurRoom setScript: 0)
				)
			)
		)
		(cond
			((SteppedOn gEgo 8)
				(gTheMusic fade: 127 5 5 0)
			)
			((SteppedOn gEgo 16)
				(gTheMusic fade: 90 5 5 0)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 340 0) ; "You are in the Casino's hotel. Doors line every wall, many with "Do Not Disturb" signs hanging from their doorknobs."
				(cond
					((== gFloorTo 4)
						(Print 340 1) ; "There's a door with a heart on it to the west."
					)
					((and (== (gEgo x:) 156) (== (gEgo y:) 133))
						(Print 340 2) ; "There are buttons labeled "one" through "eight.""
					)
					(else
						(return 1)
					)
				)
			)
			(5 ; Talk
				(Print 340 3) ; "strangers in the night, da da da dee da..."
				(Print 340 4 #at -1 140) ; "(How you love Muzak.)"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 350)
			(gTheMusic fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sUpElevator of Script
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
					setCycle: Fwd
					setMotion: MoveTo (elevator x:) -20 self
				)
			)
			(3
				(if (== (++ gFloorTo) floorWant)
					(if (== gFloorTo 8)
						(gCurRoom newRoom: 350)
					else
						(FadeIt)
						(gCurRoom setScript: sArriveUp)
					)
				else
					(FadeIt)
					(gCurRoom setScript: sGoUp)
				)
			)
		)
	)
)

(instance sGoUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(elevator
					view: 331
					y: 190
					setCycle: Fwd
					setMotion: MoveTo (elevator x:) -20 self
				)
			)
			(1
				(if (== (++ gFloorTo) floorWant)
					(if (== gFloorTo 8)
						(gCurRoom newRoom: 350)
					else
						(FadeIt)
						(gCurRoom setScript: sArriveUp)
					)
				else
					(FadeIt)
					(self init:)
				)
			)
		)
	)
)

(instance sDownElevator of Script
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
				(= register 16)
				(gEgo z: 1000 hide: normal: 0)
				(elevator
					view: 331
					cel: 0
					setCycle: Rev
					setMotion: MoveTo (elevator x:) 190 self
				)
			)
			(3
				(if (== (-- gFloorTo) floorWant)
					(if (== gFloorTo 1)
						(gCurRoom newRoom: 330)
					else
						(FadeIt)
						(gCurRoom setScript: sArriveDown)
					)
				else
					(FadeIt)
					(gCurRoom setScript: sGoDown)
				)
			)
		)
	)
)

(instance sGoDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(elevator
					view: 331
					y: -20
					setCycle: Rev
					setMotion: MoveTo (elevator x:) 190 self
				)
			)
			(1
				(if (== (-- gFloorTo) floorWant)
					(if (== gFloorTo 1)
						(gCurRoom newRoom: 330)
					else
						(FadeIt)
						(gCurRoom setScript: sArriveDown)
					)
				else
					(FadeIt)
					(self init:)
				)
			)
		)
	)
)

(instance sArriveUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 8)
				(elevator
					view: 331
					y: 190
					setCycle: Fwd
					setMotion: MoveTo (elevator x:) 133 self
				)
			)
			(1
				(elevator setCycle: End self)
			)
			(2
				(gTheMusic3 number: 340 play:)
				(gEgo x: 156 y: 133 z: 0 show:)
				(NormalEgo 2)
				(elevator view: 332 stopUpd:)
				(= cycles 1)
			)
			(3
				(if (not (IsFlag 97)) ; fGotDizzy
					(SetFlag 97) ; fGotDizzy
					(Print 340 5) ; "Whew! You're dizzy."
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sArriveDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 16)
				(elevator
					view: 331
					y: -20
					setCycle: Rev
					setMotion: MoveTo (elevator x:) 133 self
				)
			)
			(1
				(elevator setCycle: End self)
			)
			(2
				(gTheMusic3 number: 340 play:)
				(gEgo x: 156 y: 133 z: 0 show:)
				(NormalEgo 2)
				(elevator view: 332 stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sElevatorScript of Script
	(properties)

	(method (init &tmp i j)
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

(instance sFrom390 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo egoSpeed: view: 808 loop: 3 cel: 0 setCycle: End self)
			)
			(1
				(Print 340 6) ; "You close the door behind you, and jiggle the knob to confirm it is locked."
				(gEgo setCycle: Beg self)
			)
			(2
				(NormalEgo 1)
				(gEgo setHeading: 90 self)
			)
			(3
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
				(Print 340 7) ; "Not one for those long elevator rides, eh, Larry?"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sDoorMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 340 8 #dispose) ; "You rap your knuckles on the door."
				(gEgo
					egoSpeed:
					view: 808
					setLoop: (if (< (gEgo x:) 160) 1 else 0)
					setCel: 0
					setCycle: End self
				)
				(gTheMusic3 number: 341 loop: 1 play: self)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(= seconds 2)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(switch (Random 34 50)
					(34
						(Print 340 9) ; "Hey, Scott, the girls are here!!"
					)
					(35
						(Print 340 10) ; "It says `Do NOT Disturb!' Can't you read?"
					)
					(36
						(Print 340 11) ; "You hear some extremely heavy breathing."
					)
					(37
						(Print 340 12) ; "Go away! I gave at the office!"
					)
					(38
						(Print 340 13) ; "Oh, Chris, there's someone at the door!"
						(Print 340 14) ; "They're gonna have to wait, Kim Baby! It's too late for me to stop now!!"
					)
					(39
						(Print 340 15) ; "Baaaaah. Baaaaah!"
						(Print 340 16) ; "Don't even ask, Larry!"
					)
					(40
						(Print 340 17) ; "Oh, Bruce!"
						(Print 340 18) ; "Oh, Howard!"
						(Print 340 19) ; "Oh, Terri!"
						(Print 340 20) ; "Oh, Keri!"
					)
					(41
						(Print 340 21) ; "Ken! Get off me, Ken!!"
					)
					(42
						(Print 340 22) ; "Oh, gawd, Ed!! Get in the closet. It's my husband!!"
					)
					(43
						(Print 340 23) ; "Bobbit, is that you?"
					)
					(44
						(Print 340 24) ; "Not now; I've got Wessonality!"
					)
					(45
						(Print 340 25) ; "Is that Room Service? I didn't order anchovies."
					)
					(46
						(Print 340 26) ; "An eye appears at the peephole."
						(Print 340 27) ; "Hey, Mary! Isn't it a little early for Trick or Treaters?"
					)
					(47
						(Print 340 28) ; "Oh, gawd, Ed!! Get in the closet. It's my wife!!"
					)
					(48
						(Print 340 29) ; "Hmmm. Is that the smell of burning rubber?"
					)
					(49
						(Print 340 30) ; "Oh, Jeff. You really know how to hurt a guy!"
					)
					(50
						(Print 340 31) ; "Get away from him, you bully! He's mine."
					)
				)
				(= seconds 2)
			)
			(4
				(Print 340 32) ; "This must not be the right door, Larry."
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sSuiteDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					egoSpeed:
					view: 808
					setLoop: (if (< (gEgo x:) 160) 1 else 0)
					setCel: 0
					setCycle: End self
				)
				(gTheMusic3 number: 341 loop: 1 play: self)
			)
			(1
				(Print 340 33) ; "You loudly rap your knuckles on the door."
				(gEgo setCycle: Beg self)
			)
			(2
				(= seconds 3)
			)
			(3
				(if (not (IsFlag 12)) ; fFawnInRoom
					(Print 340 34) ; "There is no response to your knock, but now your knuckles hurt."
					(NormalEgo)
					(HandsOn)
					(self dispose:)
				else
					(if (and (IsFlag 24) (not (IsFlag 36))) ; fOrderedWine, fSeenDeliveryBoyGag
						(Print 340 35) ; "Fawn's sexy voice oozes through the door, "Oh, baby, it's you! You're back!!""
						(Print 340 36) ; "There's a click as she unlocks the door, then "Come on in, you wonderful hunk!""
						(Print 340 37) ; "You can't wait!"
					else
						(Print 340 38) ; "Fawn's delicate voice booms out across the hotel, "Just a minute, Larry!""
						(Print 340 39) ; "There's a click as she unlocks the door, then a piercing "Come on in. The door's open.""
					)
					(Print 340 40) ; "Subtly, you shout, "Here I come, baby!""
					(gTheMusic fade:)
					(NormalEgo 1)
					(gCurRoom newRoom: 390)
				)
			)
		)
	)
)

(instance aNumber of ElevatorNumbers
	(properties
		description {a button}
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

(instance elevator of Actor
	(properties
		x 156
		y 133
		description {the elevator}
		sightAngle 40
		approachY 133
		yStep 12
		view 332
		priority 10
		signal 24592
		illegalBits 0
	)

	(method (init)
		(self approachX: 155)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (and (== (gEgo x:) 156) (== (gEgo y:) 133))
					(Print 340 2) ; "There are buttons labeled "one" through "eight.""
				else
					(Print 340 41) ; "You marvel at the hotel's efficiency. The elevator is always waiting for you."
				)
			)
			(3 ; Do
				(gCurRoom setScript: sElevatorScript)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance floorNumber of View
	(properties
		x 160
		y 86
		view 333
		loop 1
		priority 14
		signal 16400
	)
)

(instance theHeart of Prop
	(properties
		x 20
		y 113
		description {a heart}
		approachX 40
		approachY 138
		lookStr {The hotel has stuck a cheap plastic heart to the door with a thumbtack. That's all it takes to create a Honeymoon Suite!}
		view 340
		loop 1
	)

	(method (doVerb)
		(Print 340 42) ; "The cheap, plastic heart is not worth taking."
	)
)

(instance suiteDoor of Feature
	(properties
		x 19
		y 128
		z 15
		nsTop 93
		nsLeft 7
		nsBottom 134
		nsRight 32
		description {the door with the heart on it}
		sightAngle 40
		approachX 40
		approachY 138
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 340 43) ; "It's a door not unlike all the others, except this one has a cute, little, trite, cracked, plastic heart stuck to it with a thumbtack."
			)
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sSuiteDoor)
			)
			(4 ; Inventory
				(Print 340 44) ; "It's no good. The door resists all of your efforts."
			)
			(else
				(super doVerb: theVerb invItem &rest)
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
		signal 16400
	)
)

(instance door1 of Feature
	(properties
		x 11
		y 113
		nsTop 93
		nsLeft 7
		nsBottom 134
		nsRight 32
		description {the door}
		sightAngle 40
		approachX 40
		approachY 138
	)

	(method (doVerb theVerb invItem)
		(door2 doVerb: theVerb invItem)
	)
)

(instance door2 of Feature
	(properties
		x 45
		y 112
		nsTop 94
		nsLeft 45
		nsBottom 130
		nsRight 62
		description {the door}
		sightAngle 40
		approachX 71
		approachY 132
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 340 45) ; "It's a door just like all the others."
			)
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sDoorMessage)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door3 of Feature
	(properties
		x 100
		y 108
		nsTop 91
		nsLeft 95
		nsBottom 125
		nsRight 121
		description {the door}
		sightAngle 40
		approachX 118
		approachY 129
	)

	(method (doVerb theVerb invItem)
		(door2 doVerb: theVerb invItem)
	)
)

(instance door4 of Feature
	(properties
		x 208
		y 108
		nsTop 94
		nsLeft 181
		nsBottom 123
		nsRight 203
		description {the door}
		sightAngle 40
		approachX 187
		approachY 130
	)

	(method (doVerb theVerb invItem)
		(door2 doVerb: theVerb invItem)
	)
)

(instance door5 of Feature
	(properties
		x 265
		y 114
		nsTop 93
		nsLeft 239
		nsBottom 135
		nsRight 262
		description {the door}
		sightAngle 40
		approachX 240
		approachY 135
	)

	(method (doVerb theVerb invItem)
		(door2 doVerb: theVerb invItem)
	)
)

(instance door6 of Feature
	(properties
		x 308
		y 122
		nsTop 99
		nsLeft 285
		nsBottom 145
		nsRight 305
		description {the door}
		sightAngle 40
		approachX 279
		approachY 145
	)

	(method (doVerb theVerb invItem)
		(door2 doVerb: theVerb invItem)
	)
)

(instance ashtray of Feature
	(properties
		x 52
		y 149
		nsTop 137
		nsLeft 46
		nsBottom 161
		nsRight 59
		description {an ashtray}
		sightAngle 40
		lookStr {There must be a lot of smokers in this hotel. It stinks!}
	)
)

(instance plants of Feature
	(properties
		x 160
		y 140
		nsTop 125
		nsLeft 114
		nsBottom 155
		nsRight 206
		description {the plants}
		sightAngle 40
		lookStr {They almost look real, don't they?}
	)
)

(instance elevatorShaft of Feature
	(properties
		x 159
		y 74
		nsTop -1
		nsLeft 128
		nsBottom 150
		nsRight 190
		description {the elevator shaft}
		sightAngle 40
		approachX 156
		approachY 133
		lookStr {That elevator must be made by the DNA Company.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(elevator doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

