;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31500)
(include sci.sh)
(use Main)

(public
	rm31v500 0
)

(instance rm31v500 of ShiversRoom
	(properties
		picture 31500
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31520
	)

	(method (init)
		(self createPoly: 80 20 180 20 180 120 80 120 80 20)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31510
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31510
	)
)

