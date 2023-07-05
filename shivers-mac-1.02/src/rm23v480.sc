;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23480)
(include sci.sh)
(use Main)

(public
	rm23v480 0
)

(instance rm23v480 of ShiversRoom
	(properties
		picture 23480
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
		nextRoom 23470
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23450
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23390
	)

	(method (init)
		(self createPoly: 150 54 109 54 109 98 91 124 171 124 151 99 151 54)
		(super init: &rest)
	)
)

