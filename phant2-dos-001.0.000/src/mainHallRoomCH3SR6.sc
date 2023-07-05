;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3063)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use System)

(public
	mainHallRoomCH3SR6 0
)

(instance mainHallRoomCH3SR6 of P2Room
	(properties
		picture 112
		north 3013
		south 3023
	)

	(method (init)
		(super init: &rest)
		(exitDoorFeature init: (proc63002_10 246 215 238 73 375 78 374 204))
		(netRoomDoorFeature init: (proc63002_10 62 1 111 18 133 333 86 333))
		(paulsDoorFeature init: (proc63002_10 522 14 585 0 563 333 511 333))
		(officeDoorFea init:)
		(gGame handsOn: 1)
	)
)

(instance exitDoorFeature of ExitFeature
	(properties
		nextRoom 900
		exitScene 3370
	)
)

(instance netRoomDoorFeature of ExitFeature
	(properties
		nextRoom 3133
		exitScene 3321
	)

	(method (init)
		(if (and (IsFlag 316) (not (SetFlag 317)))
			(= scene 6240)
			(= sceneScored 1)
			(= nextRoom (= exitScene 0))
		)
		(super init: &rest)
	)
)

(instance paulsDoorFeature of P2Feature
	(properties
		scene 3322
	)
)

(instance officeDoorFea of ExitFeature
	(properties)

	(method (init)
		(if (not (IsFlag 371))
			(super init: (proc63002_10 446 35 460 23 457 333 441 318))
			(= whoDoit officeDoorCode)
		)
	)
)

(instance officeDoorCode of Code
	(properties)

	(method (doit)
		(gSceneList add: 3340)
		(if (not (SetFlag 375))
			(gSceneList add: 5870)
			(gCurRoom newRoom: 4013) ; curtisCubicleRoomCH3SR1
			(SetFlag 325)
		else
			(gCurRoom newRoom: 3313) ; mainOfficeRoomCH3SR1
		)
	)
)

