;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20070)
(include sci.sh)
(use Main)

(public
	rm20v070 0
)

(instance rm20v070 of ShiversRoom
	(properties
		picture 20070
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 20350
	)

	(method (init)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20080
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 81 220 81 220 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20100
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 81 0 81 0 0)
		(super init: &rest)
	)
)

