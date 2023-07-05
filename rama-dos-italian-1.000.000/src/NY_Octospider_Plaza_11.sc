;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5311)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use Feature)

(public
	NY_Octospider_Plaza_11 0
)

(instance NY_Octospider_Plaza_11 of Location
	(properties
		noun 1
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(5310 ; NY_Octospider_Plaza_10
				(self addPicObj: faceNW faceNE faceSE faceSW faceNW)
			)
			(5315 ; NY_Octospider_Plaza_15
				(self addPicObj: faceSW faceNW faceNE faceSE faceSW)
			)
			(else
				(self addPicObj: faceSE faceSW faceNW faceNE faceSE)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 5315) ; NY_Octospider_Plaza_15
			(= exitStyle 13)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance faceSE of CameraAngle
	(properties
		heading 225
		picture 5343
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom10 init:)
		(gCurRoom exitN: exitToRoom10)
		(super init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		heading 135
		picture 5344
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToRoom15 init:)
		(gCurRoom exitN: exitToRoom15)
		(super init:)
		(museum_135 init:)
	)
)

(instance faceNW of CameraAngle
	(properties
		heading 45
		picture 5341
		edgeS 0
		edgeN 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceSW of CameraAngle
	(properties
		heading 315
		picture 5342
		edgeS 0
		edgeN 0
	)
)

(instance exitToRoom10 of ExitFeature
	(properties
		nsBottom 247
		nsLeft 95
		nsRight 522
		nsTop 97
		nextRoom 5310
	)
)

(instance exitToRoom15 of ExitFeature
	(properties
		nsBottom 254
		nsLeft 54
		nsRight 336
		nsTop 100
		nextRoom 5315
	)
)

(instance museum_135 of Feature
	(properties
		noun 23
		x 190
		y 187
		nsBottom 205
		nsLeft 147
		nsRight 234
		nsTop 170
		case 2
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

