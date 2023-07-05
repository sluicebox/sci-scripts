;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4122)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Actor)

(public
	bk2MusAntDoor 0
)

(instance bk2MusAntDoor of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(4105 ; bk2AntMusDoor
				(self addPicObj: faceMuseum faceAnteroom faceMuseum)
			)
			(4112 ; bk2Museum
				(self addPicObj: faceAnteroom faceMuseum faceAnteroom)
			)
			(else
				(self addPicObj: faceMuseum faceAnteroom faceMuseum)
			)
		)
	)
)

(instance faceAnteroom of CameraAngle
	(properties
		picture 4124
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToAnteroom init:)
		(gCurRoom exitN: exitToAnteroom)
		(super init:)
	)
)

(instance faceMuseum of CameraAngle
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
				(= picture 4164)
				(jewel1 init: global117)
			else
				(= picture 4167)
			)
		else
			(= picture 4123)
		)
		(super init:)
		(exitToMuseum init:)
		(gCurRoom exitN: exitToMuseum)
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

(instance exitToAnteroom of ExitFeature
	(properties
		nsBottom 262
		nsLeft 138
		nsRight 446
		nsTop 89
		nextRoom 4105
		exitStyle 256
	)
)

(instance jewel1 of View
	(properties
		x 295
		y 147
		loop 2
		view 4105
	)

	(method (init)
		(if (or (IsFlag 42) (IsFlag 43) (IsFlag 44))
			(super init: global117 &rest)
		)
	)
)

