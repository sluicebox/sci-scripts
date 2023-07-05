;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5519)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use System)

(public
	NYMazeT 0
)

(instance NYMazeT of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5517 ; NYMazeR
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5520 ; NYMazeU
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
		picture 5587
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
		picture 5585
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
		picture 5684
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (OneOf global256 3 4)
			(defaultExit nextRoom: 5517 init:)
		else
			(= picture 5584)
		)
		(frame_90 init:)
		(door_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5586
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5520 init:)
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
		nsLeft 1
		nsTop 3
		nsRight 589
		nsBottom 209
		x 295
		y 106
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
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
					init: -1 0 591 2 590 222 443 222 427 227 160 227 144 223 -1 221
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
		(if (OneOf global256 3 4)
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
					init: 233 12 355 10 409 62 423 153 431 190 444 221 441 227 429 227 377 215 212 215 164 227 151 227 148 220 166 171 176 110 183 66
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
		nsTop 1
		nsRight 590
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
					init: 2 2 590 2 588 221 316 182 266 182 -1 215
					yourself:
				)
		)
	)
)

