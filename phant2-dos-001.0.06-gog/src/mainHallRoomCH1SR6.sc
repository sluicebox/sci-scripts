;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3061)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)

(public
	mainHallRoomCH1SR6 0
)

(instance mainHallRoomCH1SR6 of P2Room
	(properties
		picture 112
		north 3011
		south 3021
	)

	(method (init)
		(super init: &rest)
		(exitDoorFeature init: (proc63002_10 246 215 238 73 375 78 374 204))
		(netRoomDoorFeature init: (proc63002_10 62 1 111 18 133 333 86 333))
		(paulsDoorFeature init: (proc63002_10 522 14 585 0 563 333 511 333))
		(or (usedKeyFea init:) (officeDoorFea init:))
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

	(method (handleEvent)
		(if (super handleEvent: &rest)
			(if
				(and
					(proc63002_4 26 27)
					(or (IsFlag 24) (not (IsFlag 34)))
					(not (SetFlag 25))
				)
				(= global211 (= global212 1))
				(proc63002_7 3321 6230)
			else
				(= global209 3321)
				(gCurRoom newRoom: 3131) ; networkRoomCH1SR3
			)
		)
	)
)

(instance paulsDoorFeature of P2Feature
	(properties
		scene 3322
	)
)

(instance usedKeyFea of ExitFeature
	(properties
		readyFlag 11
		nextRoom 3311
		exitScene 3340
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

(instance officeDoorFea of P2Feature
	(properties
		nextRoom 3001
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

