;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6506)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Timer)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)

(public
	backYard 0
)

(instance backYard of P2Room
	(properties
		picture 1100
		style 0
	)

	(method (init)
		(ClearFlag 1001)
		(super init: &rest)
		(momFidget init:)
		(littleCurtisFidget init:)
		(toy init:)
		(gP2SongPlyr fadeIn: 2961)
		(exitFeat init:)
		(momFeat init:)
		(rockFeat init:)
		(clipTimer init:)
		(gGame handsOn:)
	)

	(method (dispose)
		(clipTimer dispose:)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(if (== newRoomNumber 42300)
			(gP2SongPlyr fadeOut: 0)
		)
	)
)

(instance momFidget of P2Fidget
	(properties
		x 101
		y 311
		view 11000
		initStart 0
		initFinish 0
		cycleStart 0
		cycleFinish 0
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance littleCurtisFidget of P2Fidget
	(properties
		x 462
		y 289
		view 11001
		initStart 0
		initFinish 0
		cycleStart 2
		cycleFinish 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance exitFeat of ExitFeature
	(properties
		nextRoom 999
		exitDir 2
		exitScene 5007
	)

	(method (init)
		(super init: 600 40 639 296)
	)
)

(instance momFeat of ExitFeature
	(properties
		doneFlag 1504
		nextRoom 42300
		exitScene 5006
	)

	(method (init)
		(super init: 102 46 164 308)
	)
)

(instance rockFeat of ExitFeature
	(properties
		nextRoom 999
		exitScene 5005
	)

	(method (init)
		(super init: 558 203 568 216)
	)
)

(instance toy of View
	(properties
		x 546
		y 290
		view 1100
	)

	(method (init)
		(super init: &rest)
		(self setPri: 5)
	)
)

(instance clipTimer of P2Timer
	(properties)

	(method (init)
		(self start: 3 16)
	)

	(method (cue)
		(= global209 5004)
		(gCurRoom newRoom: 999) ; poorSadDeadCrazyAlienSucker
	)
)

