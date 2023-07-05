;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4113)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Feature)
(use Actor)

(public
	bk2MusElevDoor 0
)

(instance bk2MusElevDoor of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(4131 ; bkElev2
				(self addPicObj: faceMuseum faceElev faceMuseum)
			)
			(4112 ; bk2Museum
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
		heading 180
		edgeS 0
		edgeN 0
	)

	(method (init)
		(if (IsFlag 37)
			(if
				(and
					(!= (proc70_9 41) 4008)
					(!= (proc70_9 42) 4008)
					(!= (proc70_9 43) 4008)
				)
				(jewel1 init: global117)
				(jewel2 init: global117)
				(jewel3 init: global117)
				(= picture 4166)
			else
				(= picture 4168)
			)
		else
			(= picture 4131)
		)
		(exitToElev init:)
		(gCurRoom exitN: exitToElev)
		(super init:)
		(elev_180 init:)
	)
)

(instance faceMuseum of CameraAngle
	(properties
		picture 4132
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToMuseum init:)
		(gCurRoom exitN: exitToMuseum)
		(super init:)
	)
)

(instance exitToMuseum of ExitFeature
	(properties
		nsBottom 201
		nsLeft 243
		nsRight 348
		nsTop 58
		nextRoom 4112
	)
)

(instance exitToElev of ExitFeature
	(properties
		nsBottom 201
		nsLeft 243
		nsRight 348
		nsTop 58
		nextRoom 4131
	)
)

(instance jewel1 of View
	(properties
		x 292
		y 153
		loop 1
		view 4105
	)

	(method (init)
		(if (IsFlag 42)
			(super init: global117 &rest)
		)
	)
)

(instance jewel2 of View
	(properties
		x 298
		y 153
		loop 1
		cel 2
		view 4105
	)

	(method (init)
		(if (IsFlag 43)
			(super init: global117 &rest)
		)
	)
)

(instance jewel3 of View
	(properties
		x 295
		y 148
		loop 1
		cel 1
		view 4105
	)

	(method (init)
		(if (IsFlag 44)
			(super init: global117 &rest)
		)
	)
)

(instance elev_180 of Feature
	(properties
		noun 21
		nsBottom 201
		nsLeft 243
		nsRight 348
		nsTop 58
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

