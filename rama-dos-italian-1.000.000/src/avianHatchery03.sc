;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6803)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Compass)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Actor)

(public
	avianHatchery03 0
)

(instance avianHatchery03 of Location
	(properties)

	(method (init)
		(super init:)
		(faceS up: faceUpS)
		(faceUpS down: faceS)
		(faceE up: faceUpE)
		(faceUpE down: faceE)
		(switch gPrevRoomNum
			(6802 ; avianHatchery02
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
			(6804 ; avianHatchery04
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
			(6807 ; avianHatchery07
				(switch global164
					(180
						(self addPicObj: faceN faceE faceS faceW faceN)
					)
					(else
						(self addPicObj: faceE faceS faceW faceN faceE)
					)
				)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(switch picObj
					(faceS
						(northMural init: global117)
					)
					(faceUpS
						(northUpMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceS
						(northMural dispose:)
					)
					(faceUpS
						(northUpMural dispose:)
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
		picture 6810
		edgeS 0
	)

	(method (init)
		(boxExit init:)
		(hatchery04Exit init:)
		(gCurRoom exitN: hatchery04Exit)
		(gCurRoom exitNE: boxExit)
		(super init:)
		(murals_180 init:)
		(jungleGym_180 init:)
	)
)

(instance faceUpS of CameraAngle
	(properties
		heading 180
		picture 6811
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(if (not (IsFlag 147))
			(SetFlag 147)
			(Compass update:)
			(avianFly play:)
		)
		(super init:)
		(murals_180_up init:)
		(elevatedRoom_180_up init:)
		(jungleGym_180_up init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 6812
		edgeS 0
		edgeN 0
	)

	(method (init)
		(incubatorExit init:)
		(gCurRoom exitNW: incubatorExit)
		(super init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 6814
		edgeS 0
	)

	(method (init)
		(leftExit init:)
		(gCurRoom exitNW: leftExit)
		(rightExit init:)
		(gCurRoom exitNW: rightExit)
		(super init:)
		(column_90 init:)
	)
)

(instance faceUpE of CameraAngle
	(properties
		heading 90
		picture 6815
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(column_90_up init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6813
		edgeS 0
		edgeN 0
	)

	(method (init)
		(doorExit init:)
		(gCurRoom exitN: doorExit)
		(super init:)
	)
)

(instance incubatorExit of ExitFeature
	(properties
		nsBottom 168
		nsLeft 26
		nsRight 160
		nsTop 22
		nextRoom 6807
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

(instance hatchery04Exit of ExitFeature
	(properties
		nsBottom 196
		nsLeft 23
		nsRight 220
		nsTop 80
		nextRoom 6804
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

(instance boxExit of ExitFeature
	(properties
		nsBottom 155
		nsLeft 480
		nsRight 557
		nsTop 88
		nextRoom 6807
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

(instance doorExit of ExitFeature
	(properties
		nsBottom 189
		nsLeft 350
		nsRight 473
		nsTop 88
		nextRoom 6802
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9
				(= global164 180)
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
		nextRoom 6802
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

(instance rightExit of ExitFeature
	(properties
		nsBottom 225
		nsLeft 491
		nsRight 589
		nsTop 67
		nextRoom 6804
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

(instance avianFly of VMDMovie
	(properties
		movieName 6826
		endPic 6811
	)
)

(instance northMural of View
	(properties
		x 157
		y 47
		view 6803
	)
)

(instance northUpMural of View
	(properties
		x 305
		y 298
		cel 1
		view 6803
	)
)

(instance murals_180 of Feature
	(properties
		noun 14
		x 223
		y 20
		nsBottom 40
		nsLeft 124
		nsRight 322
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance jungleGym_180_up of Feature
	(properties
		noun 39
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 244 123 282 144 285 161 317 149 331 176 374 165 351 140 374 128 355 95 365 92 384 124 442 104 432 76 447 72 478 134 487 132 458 70 474 51 509 45 589 201 589 229 554 183 410 229 376 195 340 201 339 214 368 217 376 270 356 277 344 242 335 253 325 259 300 206 273 206 231 178 242 119
					yourself:
				)
		)
	)
)

(instance murals_180_up of Feature
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
					init: 245 279 443 229 468 293 248 288
					yourself:
				)
		)
	)
)

(instance elevatedRoom_180_up of Feature
	(properties
		noun 62
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 222 127 217 164 363 102 357 66
					yourself:
				)
		)
	)
)

(instance jungleGym_180 of Feature
	(properties
		noun 39
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 489 0 489 77 537 68 516 3
					yourself:
				)
		)
	)
)

(instance column_90 of Feature
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
					init: 99 2 92 110 61 112 0 198 1 234 38 234 156 265 156 291 216 291 272 278 495 262 524 262 587 276 583 200 565 142 549 118 508 112 494 1
					yourself:
				)
		)
	)
)

(instance column_90_up of Feature
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
					init: 138 3 127 26 102 40 101 66 105 92 70 191 55 290 536 291 497 122 452 0
					yourself:
				)
		)
	)
)

