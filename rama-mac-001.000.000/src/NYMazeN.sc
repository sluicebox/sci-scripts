;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5513)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use System)

(public
	NYMazeN 0
)

(instance NYMazeN of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5512 ; NYMazeM
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5514 ; NYMazeO
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
		picture 5566
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
		picture 5564
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
		picture 5665
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (OneOf global256 1 4)
			(defaultExit nextRoom: 5512 init:)
		else
			(= picture 5565)
		)
		(frame_90 init:)
		(door_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5567
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5514 init:)
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
					init: 0 0 591 0 590 232 495 208 -1 211
					yourself:
				)
		)
	)
)

(instance frame_90 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 1 591 0 590 223 -1 223
					yourself:
				)
		)
	)
)

(instance door_90 of Feature
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
					init: 233 12 356 13 408 59 421 146 442 220 442 227 426 228 378 215 213 215 164 227 149 228 149 219 161 199 169 163 182 66
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
					init: 1 1 588 1 588 210 94 210 -1 234
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
					init: 0 0 590 0 589 216 322 181 272 181 -1 215
					yourself:
				)
		)
	)
)

