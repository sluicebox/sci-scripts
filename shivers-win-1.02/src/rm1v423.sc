;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1423)
(include sci.sh)
(use Main)

(public
	rm1v423 0
)

(instance rm1v423 of ShiversRoom
	(properties
		picture 1423
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
		nextRoom 1422
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1420
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1450
	)

	(method (init)
		(self createPoly: 16 142 78 49 180 49 253 142)
		(super init: &rest)
	)
)

