;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33110)
(include sci.sh)
(use Main)

(public
	rm33v110 0
)

(instance rm33v110 of ShiversRoom
	(properties
		picture 33110
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
		nextRoom 33120
	)

	(method (init)
		(self createPoly: 84 18 84 141 203 141 203 17 84 17)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33180
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33100
	)
)

