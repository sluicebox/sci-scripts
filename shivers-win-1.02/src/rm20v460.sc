;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20460)
(include sci.sh)
(use Main)

(public
	rm20v460 0
)

(instance rm20v460 of ShiversRoom
	(properties
		picture 20460
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20920
	)

	(method (init)
		(self createPoly: 156 68 105 67 108 47 113 35 157 35)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20820
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20450
	)
)

