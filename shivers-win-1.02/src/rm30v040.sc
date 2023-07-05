;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30040)
(include sci.sh)
(use Main)

(public
	rm30v040 0
)

(instance rm30v040 of ShiversRoom
	(properties
		picture 30040
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30050
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 143 0 143 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30030
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 143 220 143 220 0)
		(super init: &rest)
	)
)

