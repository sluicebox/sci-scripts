;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1382)
(include sci.sh)
(use Main)

(public
	rm1v382 0
)

(instance rm1v382 of ShiversRoom
	(properties
		picture 1382
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1381
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1380
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1443
	)

	(method (init)
		(self createPoly: 0 84 34 37 203 37 262 107 262 141 0 141)
		(super init: &rest)
	)
)

