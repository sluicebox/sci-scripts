;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2212)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use P2Fidget)
(use Polygon)
(use System)

(public
	aptHallCH2SR1 0
)

(local
	[local0 4] = [256 39 392 155]
)

(instance aptHallCH2SR1 of P2Room
	(properties
		picture 70
		style 0
		south 2222
	)

	(method (init)
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

(instance doorFeat of P2Feature
	(properties
		priority 200
	)

	(method (init)
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
		doneFlag 205
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
			(gCurRoom newRoom: 2222) ; aptHallCH2SR2
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
		(if (gEgo has: 20) ; mailBundleI
			(= global209 1510)
			(ClearFlag 205)
			(gEgo put: 20) ; mailBundleI
		else
			(= global209 1560)
		)
		(gCurRoom newRoom: 900) ; mapRoom
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
		(self addVerb: 21)
		(= whoDoit itemsOnCurtis)
	)
)

(instance itemsOnCurtis of Code
	(properties)

	(method (doit)
		(switch gVerb
			(30 ; mailBundleI
				(curtisFeat delVerb: 30)
				(= global209 1930)
				(gEgo put: 20 get: 7) ; mailBundleI, bondageCardI
				(SetFlag 1001)
				(gCurRoom newRoom: 2122) ; livingRoomCH2SR2
			)
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2142) ; livingRoomCH2SR4
			)
		)
	)
)

