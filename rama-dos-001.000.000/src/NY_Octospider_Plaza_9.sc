;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5309)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_9 0
)

(instance NY_Octospider_Plaza_9 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init: &rest)
		(switch gPrevRoomNum
			(5304 ; NY_Octospider_Plaza_4
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(5308 ; NY_Octospider_Plaza_8
				(self addPicObj: faceS faceW faceN faceE faceS)
			)
			(5310 ; NY_Octospider_Plaza_10
				(self addPicObj: faceE faceS faceW faceN faceE)
			)
			(else
				(self addPicObj: faceN faceE faceS faceW faceN)
			)
		)
	)
)

(instance faceS of CameraAngle
	(properties
		heading 270
		picture 5333
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToMaze init:)
		(gCurRoom exitN: exitToMaze)
		(super init: &rest)
		(maze_270 init:)
	)
)

(instance faceN of CameraAngle
	(properties
		heading 90
		picture 5335
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 239)
			(= picture 5390)
		)
		(exitToRoom4 init:)
		(exitToRoom8 init:)
		(super init: &rest)
		(octohedron_90 init:)
	)
)

(instance faceW of CameraAngle
	(properties
		picture 5336
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom10 init:)
		(gCurRoom exitN: exitToRoom10)
		(super init: &rest)
	)
)

(instance faceE of CameraAngle
	(properties
		heading 180
		picture 5334
		edgeS 0
		edgeN 0
	)
)

(instance exitToRoom4 of ExitFeature
	(properties
		nsBottom 235
		nsLeft 113
		nsRight 320
		nsTop 120
		nextRoom 5304
	)
)

(instance exitToRoom8 of ExitFeature
	(properties
		nsBottom 237
		nsLeft 375
		nsRight 556
		nsTop 113
		nextRoom 5308
	)
)

(instance exitToRoom10 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5310
	)
)

(instance exitToMaze of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5518
	)
)

(instance octohedron_90 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 493 135 550 131 562 177 538 182 513 183 471 182 504 173
					yourself:
				)
		)
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
					init: 122 0 326 2 325 184 115 192
					yourself:
				)
		)
	)
)

