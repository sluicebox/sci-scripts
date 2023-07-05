;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5517)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use System)

(public
	NYMazeR 0
)

(instance NYMazeR of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5518 ; NYMazeS
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(5516 ; NYMazeQ
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5519 ; NYMazeT
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5582
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5518 init:)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 180
		picture 5580
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
		picture 5583
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5516 init:)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5681
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (OneOf global256 3 4)
			(defaultExit nextRoom: 5519 init:)
		else
			(= picture 5581)
		)
		(frame_270 init:)
		(door_270 init:)
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
					init: 2 2 591 1 589 211 554 210 318 181 273 181 35 210 1 210
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
					init: 4 2 590 1 590 216 320 182 274 183 36 212 -1 210
					yourself:
				)
		)
	)
)

(instance walls_180 of Feature
	(properties
		noun 3
		x 295
		y 104
		nsBottom 209
		nsRight 590
		case 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance frame_270 of Feature
	(properties
		noun 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 1 1 591 0 589 221 0 223 yourself:)
		)
	)
)

(instance door_270 of Feature
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
					init: 233 7 361 7 411 57 425 143 446 222 446 228 433 229 380 217 212 217 161 230 147 229 145 222 154 201 163 171 171 122 178 61
					yourself:
				)
		)
	)
)

