;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4560)
(include sci.sh)
(use Main)

(public
	rm4v560 0
)

(instance rm4v560 of ShiversRoom
	(properties
		picture 4120
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 69
		nextRoom 4590
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4570
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4540
	)

	(method (init)
		(self createPoly: 176 112 86 112 117 77 117 61 145 61 145 78)
		(super init: &rest)
	)
)

