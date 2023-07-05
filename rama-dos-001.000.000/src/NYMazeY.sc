;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5523)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SoundManager)
(use Polygon)
(use Feature)

(public
	NYMazeY 0
)

(instance NYMazeY of Location
	(properties)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5522 ; NYMazeX
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(5204 ; humanPlazaRm4
				(SoundManager playMusic: 0 -1 3020)
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)

	(method (dispose)
		(if (== picObj faceS)
			(SoundManager fadeMusic: 0 20 10 1 0)
		)
		(super dispose: &rest)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5550
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
		picture 5600
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5204 init:)
		(walls_180 init:)
		(plaza_180 init:)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 90
		picture 5549
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
		picture 5551
		edgeS 0
		edgeN 0
	)

	(method (init)
		(defaultExit nextRoom: 5522 init:)
		(walls_270 init:)
		(super init: &rest)
	)
)

(instance defaultExit of ExitFeature
	(properties)

	(method (init)
		(= exitStyle (if (== nextRoom 5204) 256 else 0))
		(super init: &rest)
	)
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
					init: 1 1 589 0 588 216 462 202 0 206
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
					init: 1 2 591 0 590 202 110 211 0 229
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
					init: 0 2 590 1 590 209 553 210 319 181 272 179 -1 215
					yourself:
				)
		)
	)
)

(instance plaza_180 of Feature
	(properties
		noun 7
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 1 315 -1 318 182 274 180
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
					init: 2 2 590 1 590 230 307 182 279 180 37 210 0 211
					yourself:
				)
		)
	)
)

