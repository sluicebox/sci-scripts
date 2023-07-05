;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2102)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	CPIceport3 0
)

(instance CPIceport3 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2101 ; CPIceport2
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(2103 ; CPIceport4
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 2409
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2103 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(horns_0 init:)
		(sea_0 init:)
		(pillar_0 init:)
		(horns_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 2410
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(sea_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 2411
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 2101 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(hubSite_180 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 2412
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(lights_270 init:)
		(sea_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance horns_0 of Feature
	(properties
		noun 2
		nsLeft 270
		nsTop 37
		nsRight 321
		nsBottom 84
		x 295
		y 60
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 0 0 71 1 89 33 121 73 157 104 148 145 139 174 95 177 -1 133
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 207 131 270 147 327 145 383 132 427 109 464 79 490 46 515 10 518 1 592 1 592 87 574 103 497 175 224 176 224 157 208 137
					yourself:
				)
		)
	)
)

(instance pillar_0 of Feature
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
					init: 138 176 139 157 148 144 150 117 156 116 157 90 163 83 199 83 206 96 208 136 220 152 225 177 206 180 146 181
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 499 175 497 155 504 149 506 121 515 95 523 85 535 79 550 81 569 89 576 103 516 167
					yourself:
				)
		)
	)
)

(instance lights_270 of Feature
	(properties
		noun 5
		nsLeft 236
		nsTop 19
		nsRight 472
		nsBottom 33
		x 354
		y 26
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
					init: 461 -1 591 -1 592 69 553 61 532 61 524 64 498 50 478 30 465 12
					yourself:
				)
		)
	)
)

(instance hubSite_180 of Feature
	(properties
		noun 3
		nsLeft 257
		nsTop -2
		nsRight 335
		nsBottom 58
		x 296
		y 28
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
					init: 1 29 0 -1 54 -2 25 6 10 16
					yourself:
				)
				((Polygon new:) type: PTotalAccess init: 112 -2 134 -1 129 4 yourself:)
		)
	)
)

