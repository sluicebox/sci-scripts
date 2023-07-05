;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5502)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use Polygon)
(use Feature)

(public
	NYMazeC 0
)

(instance NYMazeC of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5503 ; NYMazeD
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5006 ; NYAvian6
				(self addPicObj: faceN faceE faceS faceW faceN)
				(SoundManager playMusic: 0 -1 3020)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)

	(method (dispose)
		(if (== picObj faceS)
			(SoundManager fadeMusic: 0 20 10 1 0)
		)
		(super dispose: &rest)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5512
		edgeN 0
		edgeS 0
	)

	(method (init)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 5509
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5006 init:)
		(walls_180 init:)
		(plaza_180 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5511
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5503 init:)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5510
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(walls_270 init:)
		(super init: &rest)
	)
)

(instance defaultExit of ExitFeature
	(properties)
)

(instance walls_0 of Feature
	(properties
		noun 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 0 591 1 591 204 142 203 2 222
					yourself:
				)
		)
	)
)

(instance walls_90 of Feature
	(properties
		noun 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 3 1 590 2 590 210 553 210 333 183 280 183 1 213
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
	(properties
		noun 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 1 590 0 591 199 311 178 280 178 1 200
					yourself:
				)
		)
	)
)

(instance plaza_180 of Feature
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
					init: 277 0 308 1 306 156 309 180 278 179 279 149
					yourself:
				)
		)
	)
)

(instance walls_270 of Feature
	(properties
		noun 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 0 591 0 590 214 525 209 0 204
					yourself:
				)
		)
	)
)

