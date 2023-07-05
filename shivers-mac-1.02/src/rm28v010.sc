;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28010)
(include sci.sh)
(use Main)

(public
	rm28v010 0
)

(instance rm28v010 of ShiversRoom
	(properties
		picture 28010
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 28000
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 28020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 28050
	)

	(method (init)
		(self createPoly: 58 141 58 80 208 80 208 142 58 142)
		(super init: &rest)
	)
)

