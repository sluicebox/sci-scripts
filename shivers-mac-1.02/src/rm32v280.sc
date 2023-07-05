;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32280)
(include sci.sh)
(use Main)

(public
	rm32v280 0
)

(instance rm32v280 of ShiversRoom
	(properties
		picture 32280
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
		nextRoom 32220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32210
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32170
	)

	(method (init)
		(self createPoly: 194 139 194 49 116 49 116 140 194 140)
		(super init: &rest)
	)
)

