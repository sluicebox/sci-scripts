;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1373)
(include sci.sh)
(use Main)

(public
	rm1v373 0
)

(instance rm1v373 of ShiversRoom
	(properties
		picture 1373
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1372
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1371
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1384
	)

	(method (init)
		(self createPoly: 53 141 92 28 174 27 175 43 228 141 53 141)
		(super init: &rest)
	)
)

