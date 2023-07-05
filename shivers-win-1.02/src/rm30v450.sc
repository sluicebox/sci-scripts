;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30450)
(include sci.sh)
(use Main)

(public
	rm30v450 0
)

(instance rm30v450 of ShiversRoom
	(properties
		picture 30450
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30460
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30480
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30430
	)

	(method (init)
		(self createPoly: 104 50 148 50 148 115 160 124 99 124 104 117 104 52)
		(super init: &rest)
	)
)

