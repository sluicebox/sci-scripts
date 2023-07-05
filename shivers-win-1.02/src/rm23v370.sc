;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23370)
(include sci.sh)
(use Main)

(public
	rm23v370 0
)

(instance rm23v370 of ShiversRoom
	(properties
		picture 23370
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
		nextRoom 23670
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23680
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23350
	)

	(method (init)
		(self createPoly: 98 94 105 39 102 22 157 22 159 87 164 100 95 100)
		(super init: &rest)
	)
)

