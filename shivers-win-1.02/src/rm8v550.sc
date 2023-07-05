;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8550)
(include sci.sh)
(use Main)

(public
	rm8v550 0
)

(instance rm8v550 of ShiversRoom
	(properties
		picture 8550
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForwardLeft init: 3)
		(efExitForwardRight init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8540
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8500
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 8040
	)

	(method (init)
		(self createPoly: 71 143 68 69 68 1 21 1 21 143)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 8330
	)

	(method (init)
		(self createPoly: 219 143 224 69 224 1 243 1 243 143)
		(super init: &rest)
	)
)

