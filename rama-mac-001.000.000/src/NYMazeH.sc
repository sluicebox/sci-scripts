;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5507)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use System)

(public
	NYMazeH 0
)

(instance NYMazeH of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5508 ; NYMazeI
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5505 ; NYMazeF
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
		picture 5528
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
		picture 5526
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
		picture 5627
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (OneOf global256 0 4)
			(defaultExit nextRoom: 5508 init:)
			(door_90 case: 5)
		else
			(= picture 5527)
			(door_90 case: 6)
		)
		(frame_90 init:)
		(door_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5525
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5505 init:)
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
		nsTop 1
		nsRight 590
		nsBottom 215
		x 295
		y 108
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance door_90 of Feature
	(properties
		noun 10
		case 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 244 40 344 41 387 82 391 140 398 179 409 213 398 216 362 208 227 208 191 216 181 216 181 210 192 183 199 156 202 119 202 85
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
					init: 127 1 463 -1 488 212 103 212
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
					init: -1 0 591 1 590 209 68 207 -1 222
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
					init: 3 2 591 1 590 217 315 181 280 180 0 214
					yourself:
				)
		)
	)
)

