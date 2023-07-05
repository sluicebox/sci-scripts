;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2106)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	CPIceport7 0
)

(instance CPIceport7 of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(2105 ; CPIceport6
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(2107 ; CPIceport8
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
		picture 2425
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2107 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(sea_0 init:)
		(horns_0 init:)
		(port_0 init:)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 2426
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(sea_90 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 2427
		edgeS 0
		edgeN 0
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 2428
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 2105 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(port_270 init:)
		(sea_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
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
					init: 1 222 1 -1 99 -2 98 13 75 27 66 38 60 79 46 81 42 81 13 221
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 184 -2 305 -1 306 62 299 127 299 163 267 163 255 96 246 84 238 55 231 40 197 18 192 11 192 7
					yourself:
				)
		)
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
					init: 1 -2 76 -1 104 50 145 93 198 127 253 144 314 146 376 133 432 104 479 63 504 25 518 -2 593 -1 592 201 1 201
					yourself:
				)
		)
	)
)

(instance horns_0 of Feature
	(properties
		noun 2
		x 294
		y 59
		nsBottom 82
		nsLeft 270
		nsRight 318
		nsTop 36
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance port_0 of Feature
	(properties
		noun 8
		x 296
		y 247
		nsBottom 292
		nsRight 592
		nsTop 203
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance port_270 of Feature
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
					init: 281 33 308 32 308 56 375 290 217 291 282 57
					yourself:
				)
		)
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
					init: 334 0 411 0 396 21 366 39 356 57 350 82 339 97 330 140 313 85 307 34 323 33 331 23 334 11
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 495 1 591 1 593 225 582 223 551 81 537 81 530 39 522 29 501 15 497 15
					yourself:
				)
		)
	)
)

