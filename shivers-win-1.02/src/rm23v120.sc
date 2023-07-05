;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23120)
(include sci.sh)
(use Main)

(public
	rm23v120 0
)

(instance rm23v120 of ShiversRoom
	(properties
		picture 23120
	)

	(method (init)
		(gSounds fade: 32350 42 6 6 0 0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForwardLeft init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23110
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 23080
	)

	(method (init)
		(self createPoly: 21 0 70 0 70 144 21 144 21 0)
		(super init: &rest)
	)
)

