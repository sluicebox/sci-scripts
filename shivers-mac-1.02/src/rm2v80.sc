;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2800)
(include sci.sh)
(use Main)

(public
	rm2v80 0
)

(instance rm2v80 of ShiversRoom
	(properties
		picture 2720
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2790
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2790
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2350
	)

	(method (init)
		(self createPoly: 67 143 123 72 140 72 198 142)
		(super init: &rest)
	)
)

