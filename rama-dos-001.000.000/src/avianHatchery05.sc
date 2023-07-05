;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6805)
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
	avianHatchery05 0
)

(instance avianHatchery05 of Location
	(properties)

	(method (init)
		(super init:)
		(faceS up: faceUpS)
		(faceUpS down: faceS)
		(faceW up: faceUpW)
		(faceUpW down: faceW)
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
			(6810 ; avianHatchery10
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
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
					(faceE
						(westMural init: global117)
					)
				)
			)
			(26
				(switch picObj
					(faceS
						(northMural dispose:)
					)
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
		picture 6830
		edgeS 0
	)

	(method (init)
		(hatchery04Exit init:)
		(gCurRoom exitN: hatchery04Exit)
		(super init:)
		(murals_180 init:)
	)
)

(instance faceUpS of CameraAngle
	(properties
		heading 180
		picture 6831
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
		(elevatedRoom_180_up init:)
		(jungleGym_180_up init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 6832
		edgeS 0
	)

	(method (init)
		(leftExit init:)
		(gCurRoom exitNW: leftExit)
		(rightExit init:)
		(gCurRoom exitNW: rightExit)
		(super init:)
		(jungleGym_270 init:)
		(column_270 init:)
	)
)

(instance faceUpW of CameraAngle
	(properties
		heading 270
		picture 6833
		edgeW 0
		edgeE 0
		edgeN 0
	)

	(method (init)
		(super init:)
		(jungleGym_270_up init:)
		(column_270_up init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 6835
		edgeS 0
		edgeN 0
	)

	(method (init)
		(upRampExit init:)
		(gCurRoom exitN: upRampExit)
		(super init:)
		(incubator_90 init:)
		(murals_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 6834
		edgeS 0
		edgeN 0
	)

	(method (init)
		(doorExit init:)
		(gCurRoom exitN: doorExit)
		(super init:)
	)
)

(instance upRampExit of ExitFeature
	(properties
		nsBottom 187
		nsLeft 211
		nsRight 417
		nsTop 35
		nextRoom 6810
	)
)

(instance hatchery04Exit of ExitFeature
	(properties
		nsBottom 239
		nsLeft 338
		nsRight 575
		nsTop 36
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

(instance doorExit of ExitFeature
	(properties
		nsBottom 183
		nsLeft 184
		nsRight 319
		nsTop 73
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
		nextRoom 6804
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

(instance rightExit of ExitFeature
	(properties
		nsBottom 225
		nsLeft 491
		nsRight 589
		nsTop 67
		nextRoom 6802
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

(instance avianFly of VMDMovie
	(properties
		movieName 6829
		endPic 6831
	)
)

(instance northMural of View
	(properties
		x 396
		y 47
		cel 1
		view 6805
	)
)

(instance westMural of View
	(properties
		x 224
		y 139
		view 6805
	)
)

(instance murals_90 of Feature
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
					init: 225 93 233 125 274 126 276 92
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 316 92 379 93 381 126 317 124
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
					init: 6 93 68 106 64 120 75 128 104 128 109 137 132 135 135 42 181 42 177 138 143 145 94 141 6 141 -1 96
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 361 139 581 140 551 135 465 136 451 46 405 46 404 127 367 128
					yourself:
				)
		)
	)
)

(instance murals_180 of Feature
	(properties
		noun 14
		x 467
		y 24
		nsBottom 50
		nsLeft 350
		nsRight 584
		nsTop -2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance column_270 of Feature
	(properties
		noun 37
		x 301
		y 64
		nsBottom 127
		nsLeft 128
		nsRight 475
		nsTop 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance column_270_up of Feature
	(properties
		noun 37
		x 314
		y 146
		nsBottom 288
		nsLeft 120
		nsRight 508
		nsTop 5
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance jungleGym_270 of Feature
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
					init: 2 1 25 2 28 19 76 22 77 34 57 33 67 40 63 82 86 85 88 90 50 99 5 90
					yourself:
				)
		)
	)
)

(instance jungleGym_270_up of Feature
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
					init: 3 10 55 9 7 20 27 41 95 43 107 65 74 101 60 160 74 208 64 277 17 273
					yourself:
				)
		)
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
					init: 301 149 331 107 508 177 546 277 515 291 385 282 367 212 302 200 304 146 319 107
					yourself:
				)
		)
	)
)

(instance elevatedRoom_180_up of Feature
	(properties
		noun 62
		x 318
		y 120
		nsBottom 158
		nsLeft 234
		nsRight 403
		nsTop 82
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

