;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5303)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_3 0
)

(instance NY_Octospider_Plaza_3 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(5302 ; NY_Octospider_Plaza_2
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(5304 ; NY_Octospider_Plaza_4
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
			(else
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
		)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 225
		picture 5311
		edgeS 0
		edgeN 0
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 135
		picture 5312
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom2 init:)
		(gCurRoom exitN: exitToRoom2)
		(super init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 45
		picture 5309
		edgeS 0
		edgeN 0
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 315
		picture 5310
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom4 init:)
		(gCurRoom exitN: exitToRoom4)
		(super init:)
		(maze_315 init:)
	)
)

(instance exitToRoom4 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5304
	)
)

(instance exitToRoom2 of ExitFeature
	(properties
		nsBottom 271
		nsLeft 178
		nsRight 432
		nsTop 16
		nextRoom 5302
	)
)

(instance maze_315 of Feature
	(properties
		noun 18
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 1 42 2 33 180 0 179 yourself:)
		)
	)
)

