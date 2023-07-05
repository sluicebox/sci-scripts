;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5516)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use System)

(public
	NYMazeQ 0
)

(instance NYMazeQ of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5515 ; NYMazeP
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5517 ; NYMazeR
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5577
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5579
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
		picture 5578
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5515 init:)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5517 init:)
		(if (OneOf global256 3 4)
			(= picture 5676)
		else
			(= picture 5576)
		)
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
		x 296
		y 106
		nsBottom 210
		nsLeft 4
		nsRight 589
		nsTop 3
		case 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: 1 2 591 -1 590 215 331 183 266 182 2 217
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
	(properties
		noun 3
		x 295
		y 103
		nsBottom 207
		nsLeft 1
		nsRight 589
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
					init: 1 1 590 0 588 214 314 183 271 182 1 215
					yourself:
				)
		)
	)
)

