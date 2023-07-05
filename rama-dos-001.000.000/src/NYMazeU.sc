;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5520)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use System)

(public
	NYMazeU 0
)

(instance NYMazeU of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5519 ; NYMazeT
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5506 ; NYMazeG
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5588
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5506 init:)
		(walls_0 init:)
		(sky_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5590
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
		picture 5691
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5519 init:)
		(if (OneOf global256 3 4)
			(= picture 5691)
		else
			(= picture 5591)
		)
		(walls_90 init:)
		(sky_90 init:)
		(door_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5589
		edgeS 0
		edgeN 0
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
					init: 1 2 590 2 589 210 545 209 306 179 282 178 0 213
					yourself:
				)
		)
	)
)

(instance sky_0 of Feature
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
					init: 290 1 302 1 300 56 290 55
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
					init: 0 1 591 0 590 214 318 183 264 182 36 210 0 208
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
					init: 291 1 301 1 299 48 291 47
					yourself:
				)
		)
	)
)

(instance door_90 of Feature
	(properties
		noun 10
		x 296
		y 173
		nsBottom 182
		nsLeft 279
		nsRight 313
		nsTop 164
	)

	(method (init)
		(if (OneOf global256 3 4)
			(= case 5)
		else
			(= case 6)
		)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: -1 0 591 1 589 213 490 200 -2 202
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
					init: 0 -1 590 0 589 200 101 200 -2 213
					yourself:
				)
		)
	)
)

