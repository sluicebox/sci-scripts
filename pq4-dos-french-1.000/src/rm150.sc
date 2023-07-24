;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm150 0
)

(procedure (localproc_0)
	(if
		(and
			(gPqFlags test: 71)
			(gPqFlags test: 72)
			(gPqFlags test: 73)
			(gPqFlags test: 74)
			(gPqFlags test: 75)
			(gPqFlags test: 76)
			(gPqFlags test: 77)
			(gPqFlags test: 79)
			(gPqFlags test: 80)
			(gPqFlags test: 81)
			(gPqFlags test: 82)
			(gPqFlags test: 83)
			(gPqFlags test: 84)
			(gPqFlags test: 85)
			(gPqFlags test: 86)
		)
		(gPqFlags test: 88)
	)
)

(instance rm150 of Room
	(properties
		picture 150
	)

	(method (init)
		(proc0_4 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 152 230 152 246 148 291 148 294 120 173 116 129 125 93 137 54 142 25 144 0 144
					yourself:
				)
		)
		(super init: &rest)
		(musicScript init:)
		(switch gPrevRoomNum
			(100
				(gEgo posn: 25 145 setHeading: 90)
			)
			(140
				(gEgo posn: 222 120 setHeading: 180)
			)
			(else
				(gEgo posn: 25 145 setHeading: 90)
			)
		)
		(gEgo setScaler: Scaler 86 51 147 116 normalize: 0 init:)
		(burnedDoor init: approachVerbs: 4) ; Do
		(leftWall init: approachVerbs: 1) ; Look
		(holesInWall init: approachVerbs: 61 4 1) ; casePuttyKnife, Do, Look
		(boxes init:)
		(if (and (not (gEgo has: 30)) (> gDay 4)) ; rope
			(rope init: signal: (| (rope signal:) $4000))
		)
		(ground init:)
		(lWindow init:)
		(rWindow init:)
		(sky init:)
		(doorWall init:)
		(gGame handsOn:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((< (gEgo x:) 20)
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gGlobalSound0 client: 0)
		(super dispose: &rest)
		(gTheDoits delete: self)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gPrevRoomNum 140)
					(gGlobalSound1 fade: 0 3 5 1 self)
				else
					(gGlobalSound0 fade: 0 3 5 1 self)
				)
			)
			(1
				(gGlobalSound0
					number: 150
					loop: -1
					setVol: 0
					fade: 127 1 5 0 self
					play:
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance rope of Prop
	(properties
		noun 13
		sightAngle 45
		x 252
		y 157
		z 30
		priority 200
		fixPriority 1
		view 2150
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: boxScr 0 1)
			)
			(22 ; handgun
				(gCurRoom setScript: boxScr 0 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boxes of Feature
	(properties
		noun 6
		x 300
		y 150
		z 6
	)

	(method (init)
		(self
			createPoly: 241 152 240 121 254 117 283 126 294 122 300 114 310 116 318 106 319 109 319 144 300 152
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if
					(and
						(gCast contains: rope)
						(== gDay 5)
						(not (gEgo has: 30)) ; rope
					)
					(gMessager say: noun theVerb 8 0) ; "By the looks of the debris, it appears illicit activity continues."
				else
					(gMessager say: noun theVerb 6 0) ; "Empty freight containers. This field must be used"
				)
			)
			(4 ; Do
				(gCurRoom setScript: boxScr 0 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boxScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= (gEgo x:) 260) (!= (gEgo y:) 148))
					(gEgo setMotion: PolyPath 260 148 self)
				else
					(= cycles 2)
				)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (== register 1)
					(gMessager say: 13 4 0 0 self) ; "It's rope! Most probably used for securing containers"
				else
					(= cycles 2)
				)
			)
			(4
				(if (== register 2)
					(self setScript: drawOnRopeScr self)
				else
					(gEgo view: 9850 setLoop: 1 cel: 0 setCycle: CT 2 1 self)
				)
			)
			(5
				(if (== register 1)
					(= state 12)
				)
				(= ticks 15)
			)
			(6
				(if (== register 2)
					(gGame handsOn:)
					(self dispose:)
				else
					(gEgo setCycle: CT 1 -1 self)
				)
			)
			(7
				(= ticks 30)
			)
			(8
				(gEgo setCycle: CT 2 1 self)
			)
			(9
				(= ticks 15)
			)
			(10
				(gEgo setCycle: CT 1 -1 self)
			)
			(11
				(= ticks 30)
			)
			(12
				(gEgo setCycle: CT 3 1 self)
			)
			(13
				(if (== register 1)
					(gGame points: 3)
					(gEgo get: 30) ; rope
					(rope dispose:)
					(= cycles 2)
				else
					(= ticks 30)
				)
			)
			(14
				(gEgo setCycle: Beg self)
			)
			(15
				(gEgo heading: 180 normalize: 0)
				(= cycles 2)
			)
			(16
				(if (not register)
					(gMessager say: 6 4 0 0 self) ; "As you suspected, all that's left is packing material."
				else
					(= cycles 2)
				)
			)
			(17
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance drawOnRopeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 9022 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(= ticks 90)
			)
			(2
				(gMessager say: 13 22 0 0 self) ; "A snake! No, it's rope, put the gun away Carey!"
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo heading: 180 normalize: 0)
				(= cycles 2)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance burnedDoor of Feature
	(properties
		heading 180
		noun 1
		nsLeft 212
		nsTop 65
		nsRight 239
		nsBottom 111
		sightAngle 135
		approachX 225
		approachY 120
		approachDist 10
		x 222
		y 110
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 140)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftWall of Feature
	(properties
		heading 125
		noun 11
		nsRight 153
		nsBottom 108
		sightAngle 90
		approachX 94
		approachY 57
		approachDist 25
		x 110
		y 50
	)
)

(instance holesInWall of Feature
	(properties
		nsLeft 79
		nsTop 53
		nsRight 131
		nsBottom 75
		sightAngle 90
		approachX 94
		approachY 57
		approachDist 25
		x 105
		y 53
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setInset: wallInset)
			)
			(4 ; Do
				(gCurRoom setInset: wallInset)
			)
			(52 ; notebook
				(gMessager say: 11 52 0 0) ; "The graffiti looks familiar. Maybe you ought to take a closer look..."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wallInset of Inset
	(properties
		picture 160
		disposeNotOnMe 1
	)

	(method (init &tmp [temp0 76])
		(gGame fade: 100 0 10)
		(gTheIconBar disable: 3 7 show: 0)
		(super init: &rest)
		(insetFeat init:)
		(insetGraffiti init:)
		(hole0 init:)
		(hole1 init:)
		(hole2 init:)
		(hole3 init:)
		(hole4 init:)
		(hole5 init:)
		(hole6 init:)
		(hole8 init:)
		(hole9 init:)
		(hole10 init:)
		(hole11 init:)
		(hole12 init:)
		(hole13 init:)
		(hole14 init:)
		(hole15 init:)
		(hole17 init:)
		(if (== gDay 2)
			(if (not (gPqFlags test: 71))
				(bull0 init:)
			)
			(if (not (gPqFlags test: 72))
				(bull1 init:)
			)
			(if (not (gPqFlags test: 73))
				(bull2 init:)
			)
			(if (not (gPqFlags test: 74))
				(bull3 init:)
			)
			(if (not (gPqFlags test: 75))
				(bull4 init:)
			)
			(if (not (gPqFlags test: 76))
				(bull5 init:)
			)
			(if (not (gPqFlags test: 77))
				(bull6 init:)
			)
			(if (not (gPqFlags test: 79))
				(bull8 init:)
			)
			(if (not (gPqFlags test: 80))
				(bull9 init:)
			)
			(if (not (gPqFlags test: 81))
				(bull10 init:)
			)
			(if (not (gPqFlags test: 82))
				(bull11 init:)
			)
			(if (not (gPqFlags test: 83))
				(bull12 init:)
			)
			(if (not (gPqFlags test: 84))
				(bull13 init:)
			)
			(if (not (gPqFlags test: 85))
				(bull14 init:)
			)
			(if (not (gPqFlags test: 86))
				(bull15 init:)
			)
			(if (not (gPqFlags test: 88))
				(bull17 init:)
			)
		)
		(FrameOut)
		(gGame fade: 0 100 10)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (onMe param1)
		(return (and (<= 27 (param1 x:) 294) (<= 8 (param1 y:) 136)))
	)

	(method (dispose)
		(insetFeat dispose:)
		(insetGraffiti dispose:)
		(gGame fade: 100 0 10)
		(gTheIconBar enable: 0 3 7)
		(super dispose:)
		(FrameOut)
		(gGame fade: 0 100 10)
	)
)

(class Hole of Feature
	(properties
		noun 5
	)

	(method (init)
		(super init:)
		(= nsRight (+ nsLeft 6))
		(= nsBottom (+ nsTop 6))
		(= x (+ nsLeft 3))
		(= y (- nsBottom 1))
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(cond
				((== gDay 2)
					(super doVerb: theVerb &rest)
				)
				((localproc_0)
					(gMessager say: noun theVerb 4) ; "You've already collected all the slugs that were here."
				)
				(else
					(gMessager say: noun theVerb 5) ; "SID has swept the area clean. There are no more slugs in the wall."
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance hole0 of Hole
	(properties
		nsLeft 42
		nsTop 53
	)
)

(instance hole1 of Hole
	(properties
		nsLeft 45
		nsTop 86
	)
)

(instance hole2 of Hole
	(properties
		nsLeft 60
		nsTop 60
	)
)

(instance hole3 of Hole
	(properties
		nsLeft 79
		nsTop 70
	)
)

(instance hole4 of Hole
	(properties
		nsLeft 87
		nsTop 55
	)
)

(instance hole5 of Hole
	(properties
		nsLeft 113
		nsTop 42
	)
)

(instance hole6 of Hole
	(properties
		nsLeft 125
		nsTop 49
	)
)

(instance hole8 of Hole
	(properties
		nsLeft 122
		nsTop 93
	)
)

(instance hole9 of Hole
	(properties
		nsLeft 149
		nsTop 113
	)
)

(instance hole10 of Hole
	(properties
		nsLeft 177
		nsTop 49
	)
)

(instance hole11 of Hole
	(properties
		nsLeft 210
		nsTop 47
	)
)

(instance hole12 of Hole
	(properties
		nsLeft 201
		nsTop 53
	)
)

(instance hole13 of Hole
	(properties
		nsLeft 197
		nsTop 69
	)
)

(instance hole14 of Hole
	(properties
		nsLeft 224
		nsTop 112
	)
)

(instance hole15 of Hole
	(properties
		nsLeft 246
		nsTop 61
	)
)

(instance hole17 of Hole
	(properties
		nsLeft 260
		nsTop 77
	)
)

(class Bullet of Feature
	(properties
		noun 3
		bulletFlag 0
		bulletFlag2 0
	)

	(method (init)
		(super init:)
		(= nsRight (+ nsLeft 6))
		(= nsBottom (+ nsTop 6))
		(= x (+ nsLeft 3))
		(= y nsBottom)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gPqFlags test: bulletFlag)
					(gMessager say: noun theVerb 2) ; "Careful, the slug could drop into the grass."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(61 ; casePuttyKnife
				(if (gPqFlags test: bulletFlag)
					(gMessager say: noun theVerb 2) ; "This slug is already loose. Be careful, you could"
				else
					(gGame points: 1)
					(gMessager say: noun theVerb 3) ; "You loosen the slug from the wall."
					(gPqFlags set: bulletFlag)
				)
			)
			(13 ; caseBaggies
				(if (gPqFlags test: bulletFlag)
					(gMessager say: noun theVerb 2) ; "You collect the evidence."
					(gEgo get: 1) ; ammoBaggie
					(gPqFlags set: bulletFlag2)
					(gGame points: 1)
					(self dispose:)
				else
					(gMessager say: noun theVerb 3) ; "To collect the slugs, they must first be loosened from the wall."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bull0 of Bullet
	(properties
		nsLeft 42
		nsTop 53
		bulletFlag 53
		bulletFlag2 71
	)
)

(instance bull1 of Bullet
	(properties
		nsLeft 45
		nsTop 86
		bulletFlag 54
		bulletFlag2 72
	)
)

(instance bull2 of Bullet
	(properties
		nsLeft 60
		nsTop 60
		bulletFlag 55
		bulletFlag2 73
	)
)

(instance bull3 of Bullet
	(properties
		nsLeft 79
		nsTop 70
		bulletFlag 56
		bulletFlag2 74
	)
)

(instance bull4 of Bullet
	(properties
		nsLeft 87
		nsTop 55
		bulletFlag 57
		bulletFlag2 75
	)
)

(instance bull5 of Bullet
	(properties
		nsLeft 113
		nsTop 42
		bulletFlag 58
		bulletFlag2 76
	)
)

(instance bull6 of Bullet
	(properties
		nsLeft 125
		nsTop 49
		bulletFlag 59
		bulletFlag2 77
	)
)

(instance bull8 of Bullet
	(properties
		nsLeft 122
		nsTop 93
		bulletFlag 61
		bulletFlag2 79
	)
)

(instance bull9 of Bullet
	(properties
		nsLeft 149
		nsTop 113
		bulletFlag 62
		bulletFlag2 80
	)
)

(instance bull10 of Bullet
	(properties
		nsLeft 177
		nsTop 49
		bulletFlag 63
		bulletFlag2 81
	)
)

(instance bull11 of Bullet
	(properties
		nsLeft 210
		nsTop 47
		bulletFlag 64
		bulletFlag2 82
	)
)

(instance bull12 of Bullet
	(properties
		nsLeft 201
		nsTop 53
		bulletFlag 65
		bulletFlag2 83
	)
)

(instance bull13 of Bullet
	(properties
		nsLeft 197
		nsTop 69
		bulletFlag 66
		bulletFlag2 84
	)
)

(instance bull14 of Bullet
	(properties
		nsLeft 224
		nsTop 112
		bulletFlag 67
		bulletFlag2 85
	)
)

(instance bull15 of Bullet
	(properties
		nsLeft 246
		nsTop 61
		bulletFlag 68
		bulletFlag2 86
	)
)

(instance bull17 of Bullet
	(properties
		nsLeft 260
		nsTop 77
		bulletFlag 70
		bulletFlag2 88
	)
)

(instance rmMusic of Sound ; UNUSED
	(properties
		flags 1
		number 150
		loop -1
	)
)

(instance ground of Feature
	(properties
		noun 10
		sightAngle 40
		x 153
		y 131
	)

	(method (init)
		(self
			createPoly: 164 107 305 114 286 124 251 119 237 121 239 152 1 152 0 133
		)
		(super init:)
	)
)

(instance doorWall of Feature
	(properties
		noun 12
		nsLeft 167
		nsTop 37
		nsRight 310
		nsBottom 115
		sightAngle 40
		x 238
		y 38
	)
)

(instance lWindow of Feature
	(properties
		noun 7
		nsLeft 175
		nsTop 62
		nsRight 210
		nsBottom 77
		sightAngle 40
		approachX 192
		approachY 69
		approachDist 0
		x 192
		y 69
	)
)

(instance rWindow of Feature
	(properties
		noun 7
		nsLeft 247
		nsTop 66
		nsRight 290
		nsBottom 78
		sightAngle 40
		approachX 268
		approachY 72
		approachDist 0
		x 268
		y 72
	)
)

(instance graffiti of Feature ; UNUSED
	(properties
		noun 8
		nsLeft 69
		nsTop 47
		nsRight 117
		nsBottom 64
		sightAngle 90
		approachX 94
		approachY 57
		approachDist 25
		x 90
		y 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1) ; Look
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance insetGraffiti of Feature
	(properties
		noun 8
		nsLeft 27
		nsTop 7
		nsRight 199
		nsBottom 89
		sightAngle 90
		x 90
		y 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; notebook
				(if (gPqPointFlags test: 33)
					(gMessager say: noun theVerb 1 0) ; "This information has already been notated."
				else
					(gGame points: 2 33)
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance insetFeat of Feature
	(properties
		noun 14
		nsLeft 27
		nsTop 8
		nsRight 294
		nsBottom 136
		sightAngle 90
		x 175
		y 9
	)
)

(instance sky of Feature
	(properties
		noun 9
		x 192
		y 1
	)

	(method (init)
		(self createPoly: 66 0 319 0 319 66 312 66 312 29 167 38 167 13 155 14)
		(super init:)
	)
)

