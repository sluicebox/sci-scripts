;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5509)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use System)

(public
	NYMazeJ 0
)

(instance NYMazeJ of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5510 ; NYMazeK
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5508 ; NYMazeI
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
		picture 5534
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
		picture 5536
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
		picture 5533
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5510 init:)
		(walls_90 init:)
		(sky_90 init:)
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
		(if (OneOf global256 0 4)
			(= picture 5635)
		else
			(= picture 5535)
		)
		(defaultExit nextRoom: 5508 init:)
		(walls_270 init:)
		(sky_270 init:)
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
		y 105
		nsBottom 210
		nsLeft 3
		nsRight 589
		nsTop 1
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
					init: 0 1 591 0 590 215 313 181 281 182 1 216
					yourself:
				)
		)
	)
)

(instance sky_90 of Feature
	(properties
		noun 4
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 290 1 302 0 301 31 291 31
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
		nsBottom 208
		nsLeft 1
		nsRight 590
		nsTop 2
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
					init: 2 2 591 1 588 219 306 181 275 181 1 215
					yourself:
				)
		)
	)
)

(instance sky_270 of Feature
	(properties
		noun 4
		case 4
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 291 1 301 0 299 31 290 31
					yourself:
				)
		)
	)
)

