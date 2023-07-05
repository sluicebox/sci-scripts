;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3062)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use System)

(public
	mainHallRoomCH2SR6 0
)

(instance mainHallRoomCH2SR6 of P2Room
	(properties
		picture 112
		north 3012
		south 3022
	)

	(method (init)
		(super init: &rest)
		(exitDoorFeature init: (proc63002_10 246 215 238 73 375 78 374 204))
		(netRoomDoorFeature init: (proc63002_10 62 1 111 18 133 333 86 333))
		(or
			(paulDistPaulsDoorFeature init:)
			(paulHerePaulsDoorFeature init:)
			(bobHerePaulsDoorFeature init:)
		)
		(or (noBobOfficeDoorFea init:) (bobHereOfficeDoorFea init:))
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
		nextRoom 3132
		exitScene 3321
	)
)

(instance bobHerePaulsDoorFeature of ExitFeature
	(properties
		nextRoom 4632
		exitScene 3882
	)

	(method (init)
		(if (not (IsFlag 228))
			(super init: (proc63002_10 522 14 585 0 563 333 511 333))
		else
			(return 0)
		)
	)
)

(instance paulDistPaulsDoorFeature of ExitFeature
	(properties
		readyFlag 227
		nextRoom 4632
		exitScene 4371
	)

	(method (init)
		(if (and (not (IsFlag 251)) (super init: &rest))
			(target dispose:)
			(= target (proc63002_10 522 14 585 0 563 333 511 333))
			(return 1)
		)
	)
)

(instance paulHerePaulsDoorFeature of P2Feature
	(properties
		scene 3883
		readyFlag 228
		doneFlag 229
	)

	(method (init)
		(if (super init: &rest)
			(target dispose:)
			(= target (proc63002_10 522 14 585 0 563 333 511 333))
			(return 1)
		)
	)
)

(instance noBobOfficeDoorFea of P2Feature
	(properties
		readyFlag 228
	)

	(method (init)
		(if (super init:)
			(target dispose:)
			(= target 0)
			(self addTarget: (proc63002_10 446 35 460 23 457 333 441 318))
			(= whoDoit noBobODCode)
			(return 1)
		)
	)
)

(instance noBobODCode of Code
	(properties)

	(method (doit)
		(if (not (SetFlag 231))
			(proc63002_7 3340 5830)
		else
			(= global209 3340)
			(gCurRoom newRoom: 3312) ; mainOfficeRoomCH2SR1
		)
	)
)

(instance bobHereOfficeDoorFea of P2Feature
	(properties
		scene 3881
		doneFlag 230
	)

	(method (init)
		(if (super init:)
			(target dispose:)
			(= target 0)
			(self addTarget: (proc63002_10 446 35 460 23 457 333 441 318))
			(return 1)
		)
	)
)

