;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5306)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Polygon)
(use Feature)

(public
	NY_Octospider_Plaza_6 0
)

(instance NY_Octospider_Plaza_6 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(5305 ; NY_Octospider_Plaza_5
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
			(5307 ; NY_Octospider_Plaza_7
				(self addPicObj: faceNE faceSE faceSW faceNW faceNE)
			)
			(5327 ; NY_Octospider_Plaza_27
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(else
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
		)
	)
)

(instance faceSE of CameraAngle
	(properties
		picture 5326
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if (IsFlag 239)
			(= picture 5387)
		)
		(exitToRoom5 init:)
		(super init:)
		(octohedron_225 init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5323
		heading 135
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom27 init:)
		(gCurRoom exitN: exitToRoom27)
		(cond
			((IsFlag 241)
				(= picture 5392)
			)
			((IsFlag 240)
				(= picture 15303)
			)
		)
		(super init:)
		(openLairDoor_135 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		picture 5324
		heading 45
		edgeN 0
		edgeS 0
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5325
		heading 315
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom7 init:)
		(gCurRoom exitN: exitToRoom7)
		(super init:)
	)
)

(instance exitToRoom5 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5305
	)
)

(instance exitToRoom7 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5307
	)
)

(instance exitToRoom27 of ExitFeature
	(properties
		nsLeft 178
		nsTop 16
		nsRight 432
		nsBottom 271
		nextRoom 5327
	)
)

(instance octohedron_225 of Feature
	(properties
		noun 2
		nsLeft 347
		nsTop 164
		nsRight 367
		nsBottom 179
		x 357
		y 171
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance openLairDoor_135 of Feature
	(properties
		noun 17
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 205 85 249 113 249 193 205 199
					yourself:
				)
		)
	)
)

