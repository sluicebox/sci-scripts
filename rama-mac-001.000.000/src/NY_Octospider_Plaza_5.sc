;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5305)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_5 0
)

(instance NY_Octospider_Plaza_5 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(5304 ; NY_Octospider_Plaza_4
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
			(5306 ; NY_Octospider_Plaza_6
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
			(else
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
		)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5321
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 239)
			(= picture 5386)
		)
		(exitToRoom4 init:)
		(super init:)
		(octohedron_225 init:)
		(maze_225 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5322
		heading 135
		edgeN 0
		edgeS 0
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5319
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom6 init:)
		(gCurRoom exitN: exitToRoom6)
		(super init:)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5320
		heading 315
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

(instance exitToRoom6 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5306
	)
)

(instance octohedron_225 of Feature
	(properties
		noun 2
		nsLeft 335
		nsTop 159
		nsRight 359
		nsBottom 179
		x 347
		y 169
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance maze_225 of Feature
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
					init: 570 1 591 0 594 59 575 79
					yourself:
				)
		)
	)
)

