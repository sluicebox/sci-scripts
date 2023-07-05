;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4013)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use Feature)

(public
	bk1MusElevDoor 0
)

(instance bk1MusElevDoor of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(4031 ; bkElev1
				(self addPicObj: faceMuseum faceElev faceMuseum)
			)
			(4012 ; bk1Museum
				(self addPicObj: faceElev faceMuseum faceElev)
			)
			(else
				(self addPicObj: faceMuseum faceElev faceMuseum)
			)
		)
	)
)

(instance faceElev of CameraAngle
	(properties
		edgeN 0
		edgeS 0
	)

	(method (init)
		(= global269 1)
		(if (IsFlag 36)
			(= picture 4035)
		else
			(= picture 4031)
		)
		(exitToElev init:)
		(gCurRoom exitN: exitToElev)
		(super init: &rest)
		(ELEV_0 init:)
	)
)

(instance faceMuseum of CameraAngle
	(properties
		picture 4032
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(super init:)
		(exitToMuseum init:)
		(gCurRoom exitN: exitToMuseum)
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsLeft 243
		nsTop 58
		nsRight 348
		nsBottom 201
		nextRoom 4012
	)
)

(instance exitToElev of ExitFeature
	(properties
		nsLeft 243
		nsTop 58
		nsRight 348
		nsBottom 201
		nextRoom 4031
		exitStyle 256
	)
)

(instance ELEV_0 of Feature
	(properties
		noun 21
		nsLeft 212
		nsTop 25
		nsRight 375
		nsBottom 206
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

