;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2211)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use ExitFeature)
(use P2Fidget)
(use Polygon)
(use System)

(public
	aptHallCH1SR1 0
)

(local
	[local0 4] = [256 39 392 155]
)

(instance aptHallCH1SR1 of P2Room
	(properties
		picture 70
		style 0
		south 2221
	)

	(method (init)
		(doorOnceFeat init:)
		(doorFeat init:)
		(basketFeat init:)
		(fidget init:)
		(super init: &rest)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance doorOnceFeat of ExitFeature
	(properties
		priority 200
		scene 1540
		doneFlag 19
		nextRoom 2221
	)

	(method (init)
		(= whoDoit doorOnceCode)
		(super init: [local0 0] [local0 1] [local0 2] [local0 3])
	)
)

(instance doorOnceCode of Code
	(properties)

	(method (doit)
		(if (not (IsFlag 19))
			(SetFlag 19)
		else
			(doorFeat init: [local0 0] [local0 1] [local0 2] [local0 3])
		)
	)
)

(instance doorFeat of P2Feature
	(properties
		priority 200
	)

	(method (init)
		(= readyFlag 19)
		(= whoDoit setDoorFeatProperties)
		(super init: [local0 0] [local0 1] [local0 2] [local0 3])
	)
)

(instance basketFeat of P2View
	(properties
		priority 1
		x 294
		y 246
		view 70
		doneFlag 33
		invItem 20
	)

	(method (init)
		(if (super init: &rest)
			(self addTarget: (basketPoly init:))
		)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(= global209 1500)
			(ClearFlag 1001)
			(gCurRoom newRoom: 2221) ; aptHallCH1SR2
		)
		(event claimed:)
	)
)

(instance basketPoly of Polygon
	(properties)

	(method (init)
		(super init: 300 208 354 211 352 236 299 233)
		(return self)
	)
)

(instance setDoorFeatProperties of Code
	(properties)

	(method (doit)
		(if (IsFlag 38)
			(SetFlag 112)
			(if (gEgo has: 21) ; ratI
				(if (gEgo has: 20) ; mailBundleI
					(= global209 1570)
					(gEgo put: 21) ; ratI
					(gCurRoom newRoom: 2111) ; livingRoomCH1SR1
				else
					(= global209 1570)
					(gEgo put: 21) ; ratI
					(gCurRoom newRoom: 900) ; mapRoom
				)
			else
				(if (gEgo has: 20) ; mailBundleI
					(ClearFlag 33)
					(= global209 1510)
					(gEgo put: 20) ; mailBundleI
				else
					(= global209 1560)
				)
				(gCurRoom newRoom: 900) ; mapRoom
			)
		else
			(= global209 1550)
			(gCurRoom newRoom: 2221) ; aptHallCH1SR2
		)
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
		(curtisFeat init:)
		(self setPri: 10)
	)
)

(instance curtisFeat of P2Feature
	(properties
		priority 100
	)

	(method (init)
		(super init: 142 9 304 317)
		(self delVerb: 4)
		(self addVerb: 30)
		(= whoDoit itemsOnCurtis)
	)
)

(instance itemsOnCurtis of Code
	(properties)

	(method (doit)
		(curtisFeat delVerb: 30)
		(= global209 1530)
		(gEgo put: 20 get: 6) ; mailBundleI, sexyCardI
		(if (IsFlag 112)
			(SetFlag 1001)
		)
		(gCurRoom newRoom: 2121) ; livingRoomCH1SR2
	)
)

