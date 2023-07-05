;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1372)
(include sci.sh)
(use Main)

(public
	rm1v372 0
)

(instance rm1v372 of ShiversRoom
	(properties
		picture 1372
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1371
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1373
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1361
	)

	(method (init)
		(self createPoly: 1 113 71 95 91 54 90 28 202 31 204 54 195 95 262 116)
		(super init: &rest)
	)
)

