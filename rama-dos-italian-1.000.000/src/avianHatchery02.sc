;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6802)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianHatchery02 0
)

(instance avianHatchery02 of Location
	(properties)

	(method (init)
		(super init:)
		(faceS up: faceUpS)
		(faceUpS down: faceS)
		(switch gPrevRoomNum
			(6805 ; avianHatchery05
				(switch global164
					(0
						(self addPicObj: faceS faceW faceN faceE faceS)
					)
					(90
						(self addPicObj: faceW faceN faceE faceS faceW)
					)
					(180
						(self addPicObj: faceN faceE faceS faceW faceN)
					)
					(270
						(self addPicObj: faceE faceS faceW faceN faceE)
					)
				)
			)
			(6803 ; avianHatchery03
				(switch global164
					(0
						(self addPicObj: faceS faceW faceN faceE faceS)
					)
					(90
						(self addPicObj: faceW faceN faceE faceS faceW)
					)
					(180
						(self addPicObj: faceN faceE faceS faceW faceN)
					)
					(270
						(self addPicObj: faceE faceS faceW faceN faceE)
					)
				)
			)
			(6004 ; avianRightShaft2
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceE
						(westMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceE
						(westMural dispose:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 6801
		edgeS 0
	)

	(method (init)
		(leftExit init:)
		(gCurRoom exitNW: leftExit)
		(rightExit init:)
		(gCurRoom exitNW: rightExit)
		(super init:)
		(column_180 init:)
	)
)

(instance faceUpS of CameraAngle
	(properties
		heading 180
		picture 6802
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(column_180_up init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 6803
		edgeS 0
		edgeN 0
	)

	(method (init)
		(hatchery03Exit init:)
		(gCurRoom exitN: hatchery03Exit)
		(super init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 6805
		edgeS 0
		edgeN 0
	)

	(method (init)
		(hatchery05Exit init:)
		(gCurRoom exitN: hatchery05Exit)
		(super init:)
		(incubator_90 init:)
		(muralsHatchery_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6804
		edgeS 0
		edgeN 0
	)

	(method (init)
		(doorExit init:)
		(gCurRoom exitN: doorExit)
		(super init:)
		(doorNumbers_0 init:)
	)
)

(instance doorExit of ExitFeature
	(properties
		nsBottom 234
		nsLeft 250
		nsRight 345
		nsTop 158
		nextRoom 6004
		exitStyle 13
	)
)

(instance hatchery05Exit of ExitFeature
	(properties
		nsBottom 201
		nsLeft 334
		nsRight 546
		nsTop 61
		nextRoom 6805
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 270)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hatchery03Exit of ExitFeature
	(properties
		nsBottom 179
		nsLeft 109
		nsRight 274
		nsTop 58
		nextRoom 6803
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 90)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftExit of ExitFeature
	(properties
		nsBottom 215
		nsLeft 0
		nsRight 72
		nsTop 72
		nextRoom 6805
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 0)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightExit of ExitFeature
	(properties
		nsBottom 225
		nsLeft 491
		nsRight 589
		nsTop 67
		nextRoom 6803
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 0)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance westMural of View
	(properties
		x 223
		y 113
		view 6802
	)
)

(instance column_180 of Feature
	(properties
		noun 37
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 111 0 471 2 474 114 505 113 542 177 551 235 506 225 420 248 299 257 293 280 255 279 253 255 145 244 79 231 18 238 7 234 53 138 76 111 113 109 114 94 70 70 79 27
					yourself:
				)
		)
	)
)

(instance column_180_up of Feature
	(properties
		noun 37
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 111 1 482 2 465 47 508 148 523 154 537 193 528 227 520 241 532 288 29 290 41 255 57 236 75 226 82 205 51 206 62 182 78 175 89 174 125 48
					yourself:
				)
		)
	)
)

(instance incubator_90 of Feature
	(properties
		noun 38
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 157 21 176 19 194 30 193 67 208 69 209 84 193 85 192 100 150 101 150 88 135 83
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 25 61 45 60 47 76 29 77 yourself:)
				((Polygon new:)
					type: PTotalAccess
					init: 359 78 369 78 373 43 387 38 387 103 368 105 366 93
					yourself:
				)
		)
	)
)

(instance muralsHatchery_90 of Feature
	(properties
		noun 14
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 224 67 274 70 275 97 222 93
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 316 72 353 73 354 98 321 99
					yourself:
				)
		)
	)
)

(instance doorNumbers_0 of Feature
	(properties
		noun 55
		x 287
		y 35
		nsBottom 50
		nsLeft 237
		nsRight 338
		nsTop 20
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

