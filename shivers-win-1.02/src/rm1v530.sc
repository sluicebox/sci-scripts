;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1530)
(include sci.sh)
(use Main)

(public
	rm1v530 0
)

(instance rm1v530 of ShiversRoom
	(properties
		picture 1530
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1550
	)

	(method (init)
		(self createPoly: 62 120 102 0 209 0 182 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1540
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1540
	)
)

