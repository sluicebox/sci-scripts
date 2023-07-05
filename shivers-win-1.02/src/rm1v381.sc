;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1381)
(include sci.sh)
(use Main)

(public
	rm1v381 0
)

(instance rm1v381 of ShiversRoom
	(properties
		picture 1381
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1380
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 91 101 61 101 131 20 131 20 143 0 143 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1382
	)

	(method (init)
		(self createPoly: 236 0 262 0 262 143 236 143 213 126 220 18 236 0)
		(super init: &rest)
	)
)

