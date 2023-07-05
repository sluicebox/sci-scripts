;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8120)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	HumanBench 0
)

(instance HumanBench of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(8040 ; HumanMainHall3
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(8110 ; HumanBombShop
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(8130 ; HumanBeds
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 270
		picture 8020
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(CHAIRS_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 90
		picture 8021
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 8040 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 8022
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 8130 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(FURNITURE_90 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 180
		picture 8023
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 8110 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(MIRROR_270 init:)
		(BOMB_270 init:)
		(CRANE_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance FURNITURE_90 of Feature
	(properties
		noun 11
		nsBottom 261
		nsLeft -2
		nsRight 192
		nsTop 59
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance CRANE_270 of Feature
	(properties
		noun 9
		case 3
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 119 189 135 112 227 93 245 -1 285 -1 288 82 334 115 275 180 200 194 123 184
					yourself:
				)
		)
	)
)

(instance BOMB_270 of Feature
	(properties
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 448 174 469 154 527 163 591 169 593 279 528 283 461 249 447 176
					yourself:
				)
		)
	)
)

(instance MIRROR_270 of Feature
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
					init: 432 71 474 55 477 146 448 178 429 169 431 75
					yourself:
				)
		)
	)
)

(instance CHAIRS_0 of Feature
	(properties
		noun 11
		nsBottom 286
		nsLeft 71
		nsRight 555
		nsTop 162
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

