;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35230)
(include sci.sh)
(use Main)

(public
	rm35v230 0
)

(instance rm35v230 of ShiversRoom
	(properties
		picture 35230
	)

	(method (init)
		(efExitForwardRight init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 35180
	)

	(method (init)
		(self createPoly: 142 41 142 115 216 124 241 110 241 39 142 39 142 42)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35160
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35200
	)
)

