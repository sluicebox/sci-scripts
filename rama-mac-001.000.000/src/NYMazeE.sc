;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5504)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NYMazeE 0
)

(instance NYMazeE of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5503 ; NYMazeD
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(5505 ; NYMazeF
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(5506 ; NYMazeG
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5518
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5505 init:)
		(walls_0 init:)
		(super init: &rest)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 5520
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5506 init:)
		(walls_180 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5517
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(walls_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5519
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(defaultExit nextRoom: 5503 init:)
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
					init: 0 0 591 0 590 214 366 187 312 181 282 180 37 210 2 210
					yourself:
				)
		)
	)
)

(instance walls_90 of Feature
	(properties
		noun 3
		case 4
		nsLeft 1
		nsTop 1
		nsRight 590
		nsBottom 208
		x 295
		y 104
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
					init: 2 1 590 1 589 210 554 211 304 177 288 178 0 214
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
					init: 2 3 590 1 590 209 554 210 312 181 282 180 38 210 2 210
					yourself:
				)
		)
	)
)

