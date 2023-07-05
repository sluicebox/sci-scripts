;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13423)
(include sci.sh)
(use Main)

(public
	rm13v423 0
)

(instance rm13v423 of ShiversRoom
	(properties
		picture 13273
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13421
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13420
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13433
	)

	(method (init)
		(self createPoly: 76 142 113 95 114 49 156 49 156 94 206 142)
		(super init: &rest)
	)
)

