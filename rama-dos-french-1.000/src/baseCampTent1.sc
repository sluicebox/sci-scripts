;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2001)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use Polygon)
(use Feature)

(public
	baseCampTent1 0
)

(instance baseCampTent1 of Location
	(properties)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(2002 ; baseCamp2
				(SoundManager playMusic: 0 -1 1010)
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 2002
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(sea_270 init:)
		(lights_270 init:)
		(tent_270 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 2004
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(centralPlainExit init:)
		(sea_90 init:)
		(lights_90 init:)
		(tent_90 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2003
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(centralPlainExit init:)
		(northHCyl_0 init:)
		(sea_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2001
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(tentExit init:)
		(cableCar_180 init:)
		(lockers_180 init:)
	)
)

(instance tentExit of ExitFeature
	(properties
		nsLeft 134
		nsRight 485
		nsTop 7
		nextRoom 2002
		exitStyle 256
	)
)

(instance centralPlainExit of ExitFeature
	(properties
		nextRoom 2000
		exitStyle 13
	)
)

(instance sea_0 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 56 1 196 -1 186 36 200 89 234 129 223 136 123 82
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 394 0 533 0 511 40 426 88 385 92 400 49
					yourself:
				)
		)
	)
)

(instance northHCyl_0 of Feature
	(properties
		noun 10
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 201 0 389 0 401 46 385 90 299 102 237 126 192 71
					yourself:
				)
		)
	)
)

(instance tent_270 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 9 69 48 69 246 -1 282 yourself:)
		)
	)
)

(instance lights_270 of Feature
	(properties
		noun 8
		x 298
		y 26
		nsBottom 33
		nsLeft 127
		nsRight 470
		nsTop 20
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_270 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 463 1 588 2 590 42 526 43 509 56 478 32
					yourself:
				)
		)
	)
)

(instance cableCar_180 of Feature
	(properties
		noun 12
		x 297
		y 160
		nsBottom 207
		nsLeft 268
		nsRight 327
		nsTop 113
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lockers_180 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 158 68 228 101 232 232 185 289 129 285 126 150
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 368 101 449 63 498 160 496 285 427 288 367 231
					yourself:
				)
		)
	)
)

(instance tent_90 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 502 51 589 13 589 283 507 241
					yourself:
				)
		)
	)
)

(instance lights_90 of Feature
	(properties
		noun 8
		x 296
		y 26
		nsBottom 33
		nsLeft 123
		nsRight 470
		nsTop 19
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance sea_90 of Feature
	(properties
		noun 9
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 0 128 1 108 35 49 69 0 74
					yourself:
				)
		)
	)
)

