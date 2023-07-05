;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8520)
(include sci.sh)
(use Main)

(public
	rm8v520 0
)

(instance rm8v520 of ShiversRoom
	(properties
		picture 8520
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
		nextRoom 8500
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8540
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8530
	)

	(method (init)
		(self createPoly: 91 138 88 94 67 94 61 0 209 0 201 92 182 92 180 136)
		(super init: &rest)
	)
)

