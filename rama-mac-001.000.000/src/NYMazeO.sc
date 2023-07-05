;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5514)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use System)

(public
	NYMazeO 0
)

(instance NYMazeO of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5515 ; NYMazeP
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(5513 ; NYMazeN
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
		picture 5569
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
		picture 5571
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5515 init:)
		(walls_180 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5513 init:)
		(if (OneOf global256 1 4)
			(= picture 5670)
		else
			(= picture 5570)
		)
		(walls_90 init:)
		(gate_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5568
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
					init: 0 2 589 1 589 201 100 202 -1 214
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
					init: 1 1 590 1 591 212 553 211 318 182 272 182 -1 213
					yourself:
				)
		)
	)
)

(instance gate_90 of Feature
	(properties
		noun 10
		nsLeft 278
		nsTop 160
		nsRight 316
		nsBottom 182
		x 297
		y 171
	)

	(method (init)
		(if (OneOf global256 1 4)
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
					init: 0 2 590 1 589 212 317 182 272 182 35 210 1 211
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
					init: 0 2 591 1 591 214 488 202 -1 204
					yourself:
				)
		)
	)
)

