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
		picture 5343
		heading 225
		edgeN 0
		edgeS 0
	)

	(method (init)
		(exitToRoom10 init:)
		(gCurRoom exitN: exitToRoom10)
		(super init:)
	)
)

(instance faceNE of CameraAngle
	(properties
		picture 5344
		heading 135
		edgeN 0
		edgeS 0
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
		picture 5341
		heading 45
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init: &rest)
	)
)

(instance faceSW of CameraAngle
	(properties
		picture 5342
		heading 315
		edgeN 0
		edgeS 0
	)
)

(instance exitToRoom10 of ExitFeature
	(properties
		nsLeft 95
		nsTop 97
		nsRight 522
		nsBottom 247
		nextRoom 5310
	)
)

(instance exitToRoom15 of ExitFeature
	(properties
		nsLeft 54
		nsTop 100
		nsRight 336
		nsBottom 254
		nextRoom 5315
	)
)

(instance museum_135 of Feature
	(properties
		noun 23
		case 2
		nsLeft 147
		nsTop 170
		nsRight 234
		nsBottom 205
		x 190
		y 187
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

