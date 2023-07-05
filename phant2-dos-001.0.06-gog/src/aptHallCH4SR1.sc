;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2214)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2View)
(use P2Timer)
(use P2Fidget)
(use Polygon)
(use System)

(public
	aptHallCH4SR1 0
)

(local
	[local0 4] = [256 39 392 155]
)

(instance aptHallCH4SR1 of P2Room
	(properties
		picture 70
		style 0
		south 2224
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
		doneFlag 516
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
			(gCurRoom newRoom: 2224) ; aptHallCH4SR2
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
		(if (proc63002_4 535 506)
			(ClearFlag 1001)
			(ClearFlag 506)
			(knockingTimer dispose:)
			(SetFlag 505)
			(SetFlag 504)
			(= global211 1)
			(= global212 0)
			(= global209 2190)
			(gCurRoom newRoom: 2134) ; livingRoomCH4SR3
		else
			(if (knockingTimer initialized:)
				(knockingTimer dispose:)
			)
			(if (gEgo has: 20) ; mailBundleI
				(= global209 1510)
				(ClearFlag 516)
				(gEgo put: 20) ; mailBundleI
			else
				(= global209 1560)
			)
			(gCurRoom newRoom: 900) ; mapRoom
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
		(self addVerb: 30 21 28)
		(= whoDoit itemsOnCurtis)
	)
)

(instance itemsOnCurtis of Code
	(properties)

	(method (doit)
		(switch gVerb
			(30 ; mailBundleI
				(curtisFeat delVerb: 30)
				(= global211 1)
				(= global209 2430)
				(gEgo put: 20 get: 24) ; mailBundleI, thereseNoteI
				(SetFlag 1001)
				(gCurRoom newRoom: 2124) ; livingRoomCH4SR2
			)
			(21 ; lockerI
				(= global209 1801)
				(gCurRoom newRoom: 2180) ; livingRoomFootL
			)
			(28 ; dadLetterI
				(= global209 2145)
				(= global211 1)
				(SetFlag 315)
				(gCurRoom newRoom: 2124) ; livingRoomCH4SR2
			)
		)
	)
)

