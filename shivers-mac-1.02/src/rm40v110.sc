;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40110)
(include sci.sh)
(use Main)

(public
	rm40v110 0
)

(instance rm40v110 of ShiversRoom
	(properties
		picture 40120
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
		nextRoom 40090
	)

	(method (init)
		(self createPoly: 22 126 75 98 157 90 157 1 227 1 215 126 22 126)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40100
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40100
	)
)

