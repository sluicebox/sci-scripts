;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8100)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	HumanCistern 0
)

(instance HumanCistern of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(8020 ; HumanMainHall1
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(8110 ; HumanBombShop
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
		picture 8011
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(MIRROR_0 init:)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 90
		picture 8012
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 8020 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 8013
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 8110 init:)
		(gCurRoom exitN: defaultExit)
		(super init: &rest)
		(BOMB_90 init:)
		(FURNITURE_90 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 180
		picture 8014
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
		(CRANE_270 init:)
	)
)

(instance defaultExit of ExitFeature
	(properties)
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
					init: -1 292 3 1 431 -1 417 48 234 161 238 241 170 290 -5 288
					yourself:
				)
		)
	)
)

(instance MIRROR_0 of Feature
	(properties
		noun 7
		nsBottom 201
		nsRight 200
		nsTop 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance BOMB_90 of Feature
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
					init: 4 198 49 153 114 154 113 235 66 259 3 265 0 201
					yourself:
				)
		)
	)
)

(instance FURNITURE_90 of Feature
	(properties
		noun 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 117 156 190 154 191 120 263 121 260 178 239 197 118 210 118 154
					yourself:
				)
		)
	)
)

