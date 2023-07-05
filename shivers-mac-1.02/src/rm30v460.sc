;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30460)
(include sci.sh)
(use Main)

(public
	rm30v460 0
)

(instance rm30v460 of ShiversRoom
	(properties
		picture 30460
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
		nextRoom 30470
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30450
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30380
	)

	(method (init)
		(self createPoly: 119 104 119 62 147 62 147 104 164 122 109 122 119 105)
		(super init: &rest)
	)
)

