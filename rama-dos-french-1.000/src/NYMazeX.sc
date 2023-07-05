;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5522)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NYMazeX 0
)

(instance NYMazeX of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5521 ; NYMazeW
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(5523 ; NYMazeY
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5524 ; NYMazeZ
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
		picture 5547
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5521 init:)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5545
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_180 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 5548
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5523 init:)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5546
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5524 init:)
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
					init: 1 1 591 0 589 210 553 210 315 182 273 180 34 211 2 211
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
					init: 1 0 590 0 588 212 321 183 278 183 35 210 -1 210
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
	(properties
		noun 3
		x 295
		y 105
		nsBottom 209
		nsLeft 1
		nsRight 589
		nsTop 1
		case 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 0 2 590 1 590 212 551 211 311 182 273 182 1 215
					yourself:
				)
		)
	)
)

