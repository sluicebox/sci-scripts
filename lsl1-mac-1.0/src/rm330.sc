;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
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
	rm330 0
)

(class ElevatorNumbers of View
	(properties
		y 180
		description {the button}
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
				(if (== (= gFloorTo (self cel:)) 1)
					(HandsOff)
					(self setLoop: (- (self loop:) 1))
					(Animate (gCast elements:) 0)
					(gCurRoom setScript: sNoRide)
				else
					(HandsOff)
					(gCurRoom setScript: sToElevator)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance rm330 of LLRoom
	(properties
		picture 330
		north 340
		east 320
		south 310
		west 310
	)

	(method (init)
		(Load rsSOUND 310 340)
		(LoadMany rsVIEW 331 332 808 333)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 112 150 112 135 102 117 99 82 97 46 99 15 108 18 126 36 126 36 139 0 139
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 250 189 250 184 271 176 319 176 319 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 83 145 117 135 141 135 152 147 161 147 164 140 164 135 189 135 222 143 222 152 187 162 175 162 175 169 150 169 136 163 100 162 83 150
					yourself:
				)
		)
		(gTheMusic3 loop: 1 vol: 127 flags: 1)
		(switch gPrevRoomNum
			(310 0)
			(320
				(gTheMusic number: 310 loop: -1 flags: 1 play: 90)
				(HandsOff)
				(self setScript: sFromLounge)
			)
			(340
				(HandsOff)
				(gCurRoom setScript: sFromElevator)
			)
			(else
				(gEgo posn: 160 170)
			)
		)
		(gEgo init:)
		(super init:)
		(elevator
			cycleSpeed: (+ 1 global101)
			moveSpeed: (+ 1 global101)
			init:
			approachVerbs: 3 4 10 11 ; Do, Inventory, Zipper, Taste/Smell
		)
		(if (!= gPrevRoomNum 340)
			(elevator stopUpd:)
		)
		(ashTray init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(thePhone init: approachVerbs: 3 4 10 11 2) ; Do, Inventory, Zipper, Taste/Smell, Look
		(plants init:)
		(elevatorShaft init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(theWindow init:)
		(cabaretSign init:)
		(if (== ((gInventory at: 10) owner:) 330) ; discoPass
			(discoPass init: stopUpd: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (SteppedOn gEgo 8)
					(Print 330 0) ; "You are inside the glass elevator. Your favorite kind of music is playing. You hum along, insipidly."
				else
					(Print 330 1) ; "The entrance to the Casino's Cabaret Lounge is to the right. A glass elevator awaits your entrance. An ashtray sits in front of that planter full of plastic plants."
				)
			)
			(5 ; Talk
				(Print 330 2) ; "...strangers in the night, da da da dee da..."
				(Print 330 3 #at -1 140) ; "(How you love Muzak!)"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (gEgo mover:) (gCast contains: numberPad))
			(numberPad dispose:)
			(gCast eachElementDo: #perform disposeNumbers)
			(if (== (gCurRoom script:) sElevatorScript)
				(gCurRoom setScript: 0)
			)
		)
		(cond
			(script)
			((> (gEgo x:) 278)
				(HandsOff)
				(self setScript: sGoLounge)
			)
			((SteppedOn gEgo 8)
				(gTheMusic fade: 127 5 5 0)
			)
			((SteppedOn gEgo 16)
				(gTheMusic fade: 90 5 5 0)
			)
		)
	)
)

(instance sGoLounge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 288 (gEgo y:) self)
			)
			(1
				(gTheMusic fade:)
				(gCurRoom newRoom: (gCurRoom east:))
			)
		)
	)
)

(instance sFromLounge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 288 150 setMotion: MoveTo 260 150 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sFromElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 16)
				(gEgo z: 1000 hide: normal: 0)
				(elevator
					view: 331
					y: -10
					setCycle: Rev
					setMotion: MoveTo 156 137 self
				)
			)
			(1
				(elevator setCycle: End self)
			)
			(2
				(gTheMusic3 number: 340 play:)
				(elevator cel: 0 view: 332 stopUpd:)
				(gEgo x: 156 y: 137 z: 0 show:)
				(NormalEgo 2)
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
				(gEgo z: 1000 normal: 0 hide:)
				(elevator
					view: 331
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo (elevator x:) -20 self
				)
			)
			(3
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

(instance sGetPass of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo egoSpeed: view: 808 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(Points 72 1)
				(discoPass z: 1000 dispose:)
				(gEgo get: 10 setCycle: Beg self) ; discoPass
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
				(Print 330 4) ; "Wasn't that a fast ride!"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance aNumber of ElevatorNumbers
	(properties)
)

(instance disposeNumbers of Code
	(properties)

	(method (doit obj)
		(if (obj isKindOf: ElevatorNumbers)
			(obj dispose:)
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

(instance elevator of Actor
	(properties
		x 156
		y 137
		description {the elevator}
		sightAngle 40
		approachY 137
		lookStr {That elevator must be made by the DNA Company.}
		yStep 12
		view 332
		priority 10
		signal 24592
	)

	(method (init)
		(self approachX: 155)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: sElevatorScript)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance discoPass of View
	(properties
		x 159
		y 168
		z 20
		description {the card}
		sightAngle 40
		approachX 175
		approachY 162
		lookStr {Why, it appears some sort of card is lying in the ashtray.}
		view 332
		loop 1
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sGetPass)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance ashTray of Feature
	(properties
		x 157
		y 153
		nsTop 143
		nsLeft 149
		nsBottom 164
		nsRight 165
		description {the ash tray}
		sightAngle 40
		approachX 175
		approachY 162
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (== ((gInventory at: 10) owner:) 330) ; discoPass
					(Print 330 5) ; "There's some kind of card in the ashtray."
				else
					(Print 330 6) ; "Yuck!"
				)
			)
			(3 ; Do
				(if (ObjInRoom 10)
					(HandsOff)
					(gCurRoom setScript: sGetPass)
				else
					(Print 330 7) ; "You foolishly run your fingers through the discarded cigarette butts until you find one hot enough to burn you. Ouch!"
				)
			)
			(else
				(if (== ((gInventory at: 10) owner:) 330) ; discoPass
					(Print 330 5) ; "There's some kind of card in the ashtray."
				else
					(Print 330 8) ; "The ashtray is of no further interest to you."
				)
			)
		)
	)
)

(instance thePhone of Feature
	(properties
		x 35
		y 103
		z 23
		nsTop 67
		nsLeft 27
		nsBottom 93
		nsRight 43
		description {the telephone}
		sightAngle 40
		approachX 54
		approachY 101
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 330 9) ; "The casino thoughtfully provides a courtesy telephone here in the lobby. Someone thoughtlessly filled its coin slot with chewing gum rendering it unusable to you."
			)
			(5 ; Talk
				(Print 330 10) ; "You'd love to talk on the telephone, but this one is not in working order."
			)
			(3 ; Do
				(Print 330 11) ; "You attempt to return the telephone to working order by prying the chewing gum out of the slot. You cannot. You'll just have to find another telephone."
			)
			(11 ; Taste/Smell
				(Print 330 12) ; "Yeah, it does smell like a public telephone!"
			)
			(4 ; Inventory
				(self doVerb: 3)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plants of Feature
	(properties
		x 151
		y 140
		nsTop 123
		nsLeft 103
		nsBottom 158
		nsRight 200
		description {the plants}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (SteppedOn gEgo 8)
					(Print 330 13) ; "You know, the people on those plants look like ants from up here."
					(Print 330 14) ; "Those ARE ants, you fool; we haven't left the ground yet!"
				else
					(Print 330 15) ; "The plants are a member of your favorite species: polyvinyl chloride. You notice an ashtray in front of the planter."
				)
			)
			(11 ; Taste/Smell
				(Print 330 16) ; "To you, the plants have no distinctive smell or taste."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance elevatorShaft of Feature
	(properties
		x 154
		y 66
		nsLeft 121
		nsBottom 132
		nsRight 187
		description {the elevator shaft}
		sightAngle 40
		approachX 156
		approachY 137
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

(instance theWindow of Feature
	(properties
		x 93
		y 96
		z 47
		nsTop 21
		nsLeft 67
		nsBottom 78
		nsRight 120
		description {the window}
		sightAngle 40
		lookStr {Is that a window or an illusory painting? With art like this, who can tell?}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 330 17) ; "Carefully feeling the panes, you decide this window is really a painting."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cabaretSign of Feature
	(properties
		x 226
		y 110
		z 60
		nsTop 37
		nsLeft 188
		nsBottom 63
		nsRight 265
		description {the sign}
		sightAngle 40
		lookStr {Oh, no! Look! Someone has painted the word "Cabaret" right there on the wall.}
	)
)

