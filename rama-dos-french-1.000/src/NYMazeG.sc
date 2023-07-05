;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5506)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NYMazeG 0
)

(instance NYMazeG of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5504 ; NYMazeE
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(5520 ; NYMazeU
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5593
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5504 init:)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5595
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5520 init:)
		(walls_180 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 5592
		edgeS 0
		edgeN 0
	)

	(method (init)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5594
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
					init: 2 2 589 1 590 214 305 179 281 179 -1 213
					yourself:
				)
		)
	)
)

(instance walls_90 of Feature
	(properties
		noun 3
		x 295
		y 107
		nsBottom 215
		nsLeft 1
		nsRight 589
		case 4
	)

	(method (init)
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
					init: 1 0 591 -1 589 212 310 178 276 179 0 212
					yourself:
				)
		)
	)
)

(instance walls_270 of Feature
	(properties
		noun 3
		x 296
		y 104
		nsBottom 209
		nsLeft 1
		nsRight 592
		case 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

