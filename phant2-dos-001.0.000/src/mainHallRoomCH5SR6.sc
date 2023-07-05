;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3065)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use ExitFeature)

(public
	mainHallRoomCH5SR6 0
)

(instance mainHallRoomCH5SR6 of P2Room
	(properties
		picture 112
		north 3015
		south 3025
	)

	(method (init)
		(super init: &rest)
		(gP2SongPlyr fadeIn: 3051)
		(exitDoorFeature init: (proc63002_10 246 215 238 73 375 78 374 204))
		(netRoomDoorFeature init:)
		(paulsDoorFeature init: (proc63002_10 522 14 585 0 563 333 511 333))
		(officeDoorFea init: (proc63002_10 446 35 460 23 457 333 441 318))
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
	(properties)

	(method (init)
		(super init: (proc63002_10 62 1 111 18 133 333 86 333))
		(if (not (gEgo has: 26)) ; trevCardKeyI
			(= nextRoom 3135)
			(= exitScene (if (IsFlag 756) 4930 else 3321))
		else
			(= scene 4940)
		)
	)
)

(instance paulsDoorFeature of ExitFeature
	(properties
		nextRoom 4615
		exitScene 4371
	)
)

(instance officeDoorFea of ExitFeature
	(properties
		nextRoom 3315
		exitScene 3340
	)
)

