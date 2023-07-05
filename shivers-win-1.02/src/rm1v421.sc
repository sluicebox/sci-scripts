;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1421)
(include sci.sh)
(use Main)

(public
	rm1v421 0
)

(instance rm1v421 of ShiversRoom
	(properties
		picture 1421
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1420
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1422
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

