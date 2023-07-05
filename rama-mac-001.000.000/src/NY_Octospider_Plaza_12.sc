;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5312)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_12 0
)

(instance NY_Octospider_Plaza_12 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(5313 ; NY_Octospider_Plaza_13
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(5304 ; NY_Octospider_Plaza_4
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
			(else
				(self addPicObj: faceW faceN faceE faceS faceW)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		picture 5346
		heading 270
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 239)
			(= picture 5393)
		)
		(exitToRoom4 init:)
		(super init:)
		(octohedron_270 init:)
		(maze_270 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		picture 5348
		heading 90
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom13 init:)
		(gCurRoom exitN: exitToRoom13)
		(super init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5347
		edgeN 0
		edgeS 0
	)
)

(instance faceE of CameraAngle
	(properties
		picture 5345
		heading 180
		edgeN 0
		edgeS 0
	)
)

(instance exitToRoom4 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5304
	)
)

(instance exitToRoom13 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5313
	)
)

(instance octohedron_270 of Feature
	(properties
		noun 2
		nsLeft 308
		nsTop 160
		nsRight 338
		nsBottom 181
		x 323
		y 170
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance maze_270 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 454 0 494 0 461 46 464 180 459 180
					yourself:
				)
		)
	)
)

