;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5508)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)
(use System)

(public
	NYMazeI 0
)

(instance NYMazeI of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5509 ; NYMazeJ
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
			(5507 ; NYMazeH
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
		picture 5529
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
		picture 5531
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
		picture 5532
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5509 init:)
		(walls_90 init:)
		(sky_90 init:)
		(super init: &rest)
	)
)

(instance faceW of CameraAngle
	(properties
		heading 270
		picture 5630
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (OneOf global256 0 4)
			(defaultExit nextRoom: 5507 init:)
			(door_270 case: 5)
		else
			(= picture 5530)
			(door_270 case: 6)
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
					init: -1 1 591 0 590 213 68 213 0 227
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
					init: 1 1 590 1 589 215 304 182 288 180 -1 216
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
					init: 290 1 301 1 299 76 293 77
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
					init: 0 3 590 1 590 226 502 209 0 209
					yourself:
				)
		)
	)
)

(instance door_270 of Feature
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
					init: 243 34 347 34 394 79 397 130 405 176 417 215 417 218 404 219 365 211 223 210 187 220 174 220 173 215 185 192 190 169 195 120 195 81
					yourself:
				)
		)
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
				((Polygon new:)
					type: PTotalAccess
					init: 1 2 591 0 591 222 530 215 0 215
					yourself:
				)
		)
	)
)

