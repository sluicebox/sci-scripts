;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23520)
(include sci.sh)
(use Main)

(public
	rm23v520 0
)

(instance rm23v520 of ShiversRoom
	(properties
		picture 23520
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
		nextRoom 23560
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23530
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23500
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

