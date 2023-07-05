;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37070)
(include sci.sh)
(use Main)

(public
	rm37v070 0
)

(instance rm37v070 of ShiversRoom
	(properties
		picture 37070
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
		nextRoom 37100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37030
	)

	(method (init)
		(self createPoly: 101 135 102 34 159 34 160 136)
		(super init: &rest)
	)
)

