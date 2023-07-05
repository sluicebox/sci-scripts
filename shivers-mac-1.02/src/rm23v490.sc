;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23490)
(include sci.sh)
(use Main)

(public
	rm23v490 0
)

(instance rm23v490 of ShiversRoom
	(properties
		picture 23490
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23480
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23480
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23510
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

