;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23440)
(include sci.sh)
(use Main)

(public
	rm23v440 0
)

(instance rm23v440 of ShiversRoom
	(properties
		picture 23440
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
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

