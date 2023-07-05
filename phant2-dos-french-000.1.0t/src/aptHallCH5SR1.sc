;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2215)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use ExitFeature)
(use P2Fidget)
(use PolyEdit)
(use Polygon)
(use System)

(public
	aptHallCH5SR1 0
)

(local
	[local0 4] = [256 39 392 155]
)

(instance aptHallCH5SR1 of P2Room
	(properties
		picture 70
		style 0
		south 2225
	)

	(method (init)
		(doorFeat init:)
		(noMailFeat init:)
		(mailFeat init:)
		(fidget init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance doorFeat of ExitFeature
	(properties)

	(method (init)
		(cond
			((IsFlag 726)
				(= exitScene 1560)
				(= nextRoom 900)
			)
			((IsFlag 704)
				(if (gEgo has: 1) ; walletI
					(return 0)
				else
					(= exitScene 1550)
					(= nextRoom 2225)
				)
			)
			((IsFlag 703)
				(return 0)
			)
			(else
				(= doneFlag 703)
				(= exitScene 2790)
				(= nextRoom 2225)
			)
		)
		(super init: [local0 0] [local0 1] [local0 2] [local0 3])
	)
)

(instance fidget of P2Fidget
	(properties
		x 153
		y 399
		view 10701
		cycleSpeed 7
	)

	(method (init)
		(super init:)
		(self setPri: 10)
		(curtisFeat init:)
	)
)

(instance curtisFeat of P2Feature
	(properties
		priority 100
	)

	(method (init)
		(super init: 142 9 304 317)
		(self delVerb: 4)
		(self addVerb: 21 28)
		(= whoDoit itemsOnCurtis)
	)
)

(instance itemsOnCurtis of Code
	(properties)

	(method (doit)
		(switch gVerb
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2180) ; livingRoomFootL
			)
			(28 ; dadLetterI
				(= global209 2145)
				(= global211 1)
				(SetFlag 315)
				(gCurRoom newRoom: 2125) ; livingRoomCH5SR2
			)
		)
	)
)

(instance noMailFeat of ExitFeature
	(properties
		doneFlag 703
		nextRoom 2225
		exitScene 2790
	)

	(method (init)
		(if (super init: &rest)
			(self addTarget: (basketPoly init:))
		)
	)
)

(instance mailFeat of ExitFeature
	(properties
		priority 5
		sceneScored 1
		readyFlag 703
		doneFlag 704
		nextRoom 2125
		exitScene 2880
	)

	(method (init)
		(if (super init: &rest)
			(self addTarget: (basketPoly init:))
			(mailView init:)
		)
	)
)

(instance basketPoly of Polygon
	(properties)

	(method (init)
		(super init: 300 208 354 211 352 236 299 233)
		(return self)
	)
)

(instance mailView of View
	(properties
		x 294
		y 246
		view 70
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1)
	)
)

