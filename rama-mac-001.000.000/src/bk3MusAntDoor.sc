;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4222)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use n1111)
(use Actor)

(public
	bk3MusAntDoor 0
)

(instance bk3MusAntDoor of Location
	(properties)

	(method (init)
		(super init:)
		(= plane global116)
		(switch gPrevRoomNum
			(4205 ; bk3AntMusDoor
				(self addPicObj: faceMuseum faceAnteroom faceMuseum)
			)
			(4212 ; bk3Museum
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
		heading 180
		edgeN 0
		edgeS 0
	)

	(method (init)
		(if
			(and
				(!= (proc70_9 41) 4008)
				(!= (proc70_9 42) 4008)
				(!= (proc70_9 43) 4008)
			)
			(jewel1 init: global117)
			(jewel2 init: global117)
			(jewel3 init: global117)
			(= picture 4260)
		else
			(= picture 4224)
		)
		(exitToAnteroom init:)
		(gCurRoom exitN: exitToAnteroom)
		(super init:)
	)
)

(instance faceMuseum of CameraAngle
	(properties
		picture 4223
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
		nextRoom 4212
	)
)

(instance exitToAnteroom of ExitFeature
	(properties
		nsLeft 138
		nsTop 89
		nsRight 446
		nsBottom 262
		nextRoom 4205
		exitStyle 256
	)
)

(instance jewel1 of View
	(properties
		x 294
		y 150
		view 4206
		cel 1
	)

	(method (init)
		(if (IsFlag 42)
			(super init: global117 &rest)
		)
	)
)

(instance jewel2 of View
	(properties
		x 296
		y 150
		view 4206
		cel 2
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
		view 4206
	)

	(method (init)
		(if (IsFlag 44)
			(super init: global117 &rest)
		)
	)
)

