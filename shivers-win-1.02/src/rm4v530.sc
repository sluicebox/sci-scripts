;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4530)
(include sci.sh)
(use Main)

(public
	rm4v530 0
)

(instance rm4v530 of ShiversRoom
	(properties
		picture 4060
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4520
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 192
		nextRoom 4500
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4550
	)

	(method (init)
		(self createPoly: 82 120 106 90 107 54 152 54 156 89 184 118)
		(super init: &rest)
	)
)

