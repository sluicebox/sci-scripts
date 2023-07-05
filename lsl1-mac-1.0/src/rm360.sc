;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm360 0
)

(instance rm360 of LLRoom
	(properties
		picture 360
		east 370
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 9 165 306 165 270 148 232 148 216 134 209 134 209 126 319 126 319 189 0 189 0 137 24 137
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 1 319 116 187 116 187 106 48 111 17 123 0 123
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 54 114 163 111 163 116 94 116 87 120 53 120
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 100 122 203 122 203 137 210 137 210 144 163 145 109 142
					yourself:
				)
		)
		(switch gPrevRoomNum
			(380
				(if (IsFlag 6)
					(HandsOff)
					(aEve
						cycleSpeed: (gEgo cycleSpeed:)
						moveSpeed: (gEgo moveSpeed:)
						init:
					)
					(gEgo normal: 0 view: 381 x: 70 y: 130 setLoop: 5)
					(gCurRoom setScript: sEveIsReady)
				else
					(HandsOff)
					(self setScript: sFromTub)
				)
				(gTheMusic2 fade:)
			)
			(370
				(HandsOff)
				(if (IsFlag 4)
					(Load rsVIEW 373)
					(Load rsSOUND 372)
					(aDoll
						cycleSpeed: (+ 3 global101)
						moveSpeed: (+ 3 global101)
						init:
					)
					(gEgo x: 235 y: 119)
					(gCurRoom setScript: sFlyingDoll)
				else
					(self setScript: sFromBedroom)
				)
			)
			(350
				(HandsOff)
				(LoadMany rsSOUND 350 381)
				(gTheMusic
					number: 381
					vol: 127
					loop: -1
					flags: 1
					play:
					send: 4 78 1
					send: 6 78 1
					send: 7 78 1
					send: 9 78 1
					send: 10 78 1
				)
				(gEgo loop: 1 x: 1000)
				(self setScript: sFromElevator)
			)
			(else
				(gEgo posn: 160 160)
				(gTheMusic
					number: 381
					vol: 127
					loop: -1
					flags: 1
					play:
					send: 4 78 1
					send: 6 78 1
					send: 7 78 1
					send: 9 78 1
					send: 10 78 1
				)
			)
		)
		(gEgo init:)
		(planter init:)
		(sofa init:)
		(painting2 init:)
		(painting1 init:)
		(sculpture init:)
		(fTable init:)
		(fShelf init:)
		(fSkylight init:)
		(fDoorway init:)
		(fDoorwayWest init:)
		(super init:)
		(elevator cycleSpeed: (+ 1 global101) init:)
		(elevatorF init:)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((SteppedOn gEgo 2)
				(HandsOff)
				(self setScript: sToTub)
			)
			((SteppedOn gEgo 4)
				(HandsOff)
				(self setScript: sToBedroom)
			)
		)
	)
)

(instance sToTub of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 116)
					(gEgo setMotion: PolyPath 87 112 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance sFromTub of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 106)
					(gEgo posn: 84 112 setMotion: PolyPath 137 110 self)
				else
					(gEgo posn: 65 130 setMotion: PolyPath 95 130 self)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sToBedroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 235 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance sFlyingDoll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aDoll setCycle: Fwd setMotion: MoveTo -20 96)
				(= cycles 10)
			)
			(1
				(gEgo setMotion: PolyPath 0 132 self)
			)
			(2
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance sFromBedroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 227 118 setMotion: PolyPath 209 122 self)
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
				(= cycles 3)
			)
			(1
				(sfxElevator play:)
				(elevator setCycle: End self)
			)
			(2
				(elevator setLoop: 1 setCel: 4)
				(= cycles 1)
			)
			(3
				(gEgo setLoop: 1 setCel: 0 x: 256 y: 136 setPri: 14)
				(= cycles 1)
			)
			(4
				(gEgo
					setLoop: -1
					setCel: -1
					setCycle: Walk
					setMotion: MoveTo 237 144
				)
				(= seconds 3)
			)
			(5
				(sfxElevator play:)
				(elevator setCycle: Beg self)
			)
			(6
				(elevator init:)
				(NormalEgo 1)
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
				(sfxElevator play:)
				(elevator loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(gEgo setPri: 14 setMotion: MoveTo 255 142 self)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(sfxElevator play:)
				(gEgo hide: normal: 0 setPri: -1)
				(elevator setLoop: 0 setCel: 4 setCycle: Beg self)
			)
			(4
				(= seconds 3)
			)
			(5
				(gTheMusic fade:)
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance sEveIsReady of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aEve setLoop: 3 setCycle: Walk setMotion: PolyPath 236 118)
				(gEgo setMotion: PolyPath 230 119 self)
			)
			(1
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance sfxElevator of Sound
	(properties
		number 350
	)
)

(instance aDoll of Actor
	(properties
		x 220
		y 91
		lookStr {Hurry, Larry! You're losing your new buddy!}
		yStep 5
		view 373
		priority 8
		signal 16
		xStep 7
	)
)

(instance aEve of Actor
	(properties
		x 100
		y 130
		lookStr {So far; so good!}
		view 382
		loop 3
		signal 16384
	)
)

(instance elevator of Prop
	(properties
		x 258
		y 139
		view 360
		signal 16384
		cycleSpeed 1
		detailLevel 3
	)

	(method (cue)
		(super cue:)
		(HandsOff)
		(gCurRoom setScript: sToElevator)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 360 0) ; "That's the elevator you rode in on!"
			)
			(3 ; Do
				(gEgo setMotion: PolyPath 237 144 self)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance elevatorF of Feature
	(properties
		x 254
		y 110
		nsTop 79
		nsLeft 236
		nsBottom 142
		nsRight 272
		description {the elevator}
		sightAngle 40
		lookStr {That's the elevator you rode in on!}
	)

	(method (doVerb theVerb invItem)
		(elevator doVerb: theVerb invItem)
	)
)

(instance painting1 of Feature
	(properties
		x 231
		y 135
		z 29
		nsTop 91
		nsLeft 222
		nsBottom 121
		nsRight 241
		description {the painting}
		sightAngle 40
		lookStr {The brass nameplate at the bottom says the title of this work of art is, "Right."}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 360 1) ; "Stop smearing the acrylic."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance painting2 of Feature
	(properties
		x 303
		y 152
		z 29
		nsTop 101
		nsLeft 287
		nsBottom 145
		nsRight 319
		description {the painting}
		sightAngle 40
		lookStr {The brass nameplate at the bottom says the title of this work of art is, "Left."}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 360 1) ; "Stop smearing the acrylic."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sofa of Feature
	(properties
		x 153
		y 121
		nsTop 107
		nsLeft 113
		nsBottom 135
		nsRight 194
		description {the sofa}
		sightAngle 40
		lookStr {This sofa couldn't possibly be comfortable.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 360 2) ; "Sit now? Have you looked outside?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance planter of Feature
	(properties
		x 159
		y 171
		nsTop 154
		nsBottom 189
		nsRight 319
		description {the planter}
		sightAngle 40
		lookStr {Your eyes are immediately attracted to the sculptures in the planter.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 360 3) ; "These plants aren't the only unreal thing in this penthouse!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sculpture of Feature
	(properties
		x 82
		y 145
		z 50
		nsTop 16
		nsLeft 7
		nsBottom 175
		nsRight 157
		description {the sculpture}
		sightAngle 40
		onMeCheck 4096
		lookStr {What the hell are those two sculptures planning to do!?}
	)
)

(instance fTable of Feature
	(properties
		x 160
		y 162
		z 27
		nsTop 126
		nsLeft 147
		nsBottom 144
		nsRight 173
		description {the coffee table}
		sightAngle 40
		lookStr {Be careful you don't bump your shin on THAT table!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fShelf of Feature
	(properties
		x 267
		y 149
		z 92
		nsTop 37
		nsLeft 217
		nsBottom 77
		nsRight 318
		description {the plant shelf}
		sightAngle 40
		lookStr {A shelf with pots and a plant sit above the elevator.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fSkylight of Feature
	(properties
		x 148
		y 124
		z 116
		nsLeft 92
		nsBottom 17
		nsRight 204
		description {the skylight}
		sightAngle 40
		lookStr {Looking through the skylight, you see sky.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fDoorway of Feature
	(properties
		x 153
		y 82
		nsTop 55
		nsLeft 100
		nsBottom 110
		nsRight 206
		description {the far doorway}
		sightAngle 40
		lookStr {Looking through the doorway, you see the skyline of downtown Lost Wages, spread out before you like a cheap trick.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fDoorwayWest of Feature
	(properties
		x 38
		y 80
		nsTop 21
		nsBottom 139
		nsRight 77
		description {the left doorway}
		sightAngle 40
		lookStr {Outside that doorway is the penthouse's rooftop patio.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

