;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40240)
(include sci.sh)
(use Main)

(public
	rm40v240 0
)

(instance rm40v240 of ShiversRoom
	(properties
		picture 40260
	)

	(method (init)
		(efExitChain init: 3)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitChain of ExitFeature
	(properties
		nextRoom 40260
	)

	(method (init)
		(self createPoly: 231 124 231 0 176 0 176 94 230 124)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40270
	)

	(method (init)
		(self createPoly: 42 1 58 126 195 126 162 93 162 84 114 62 107 1 42 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40250
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40250
	)
)

