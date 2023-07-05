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
		picture 8020
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
		(CHAIRS_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 8021
		heading 90
		edgeN 0
		edgeS 0
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
		edgeN 0
		edgeS 0
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
		picture 8023
		heading 180
		edgeN 0
		edgeS 0
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
		nsLeft -2
		nsTop 59
		nsRight 192
		nsBottom 261
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
		nsLeft 71
		nsTop 162
		nsRight 555
		nsBottom 286
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

