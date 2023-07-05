;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5503)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NYMazeD 0
)

(instance NYMazeD of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5502 ; NYMazeC
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(5504 ; NYMazeE
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(else
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5516
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
		picture 5514
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
		picture 5513
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5504 init:)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5515
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5502 init:)
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
		nsRight 589
		nsBottom 210
		x 294
		y 105
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
					init: 1 0 590 1 590 214 323 181 273 180 1 217
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
	(properties
		noun 3
		case 4
		nsLeft 1
		nsTop 2
		nsRight 589
		nsBottom 209
		x 295
		y 105
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
					init: 1 2 590 1 588 215 318 182 270 181 1 216
					yourself:
				)
		)
	)
)

