;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5512)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use System)

(public
	NYMazeM 0
)

(instance NYMazeM of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5511 ; NYMazeL
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5513 ; NYMazeN
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5561
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
		picture 5563
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(walls_180 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5562
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5511 init:)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5660
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (OneOf global256 1 4)
			(defaultExit nextRoom: 5513 init:)
		else
			(= picture 5560)
		)
		(frame_270 init:)
		(door_270 init:)
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
					init: 0 2 591 1 589 209 60 209 -1 220
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
					init: 0 2 590 2 590 218 336 184 252 185 0 224
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
					init: 4 2 590 2 591 220 530 210 -1 210
					yourself:
				)
		)
	)
)

(instance frame_270 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 1 0 592 0 591 226 1 226 yourself:)
		)
	)
)

(instance door_270 of Feature
	(properties
		noun 10
	)

	(method (init)
		(if (OneOf global256 1 4)
			(= case 5)
		else
			(= case 6)
		)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 218 1 374 2 422 49 440 144 454 200 465 233 448 236 387 221 203 220 141 237 126 235 126 228 141 192 169 51
					yourself:
				)
		)
	)
)

