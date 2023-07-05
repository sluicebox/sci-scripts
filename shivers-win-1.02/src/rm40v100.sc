;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40100)
(include sci.sh)
(use Main)

(public
	rm40v100 0
)

(instance rm40v100 of ShiversRoom
	(properties
		picture 40010
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40120
	)

	(method (init)
		(self createPoly: 20 20 240 20 240 120 20 120 20 20)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40110
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40110
	)
)

