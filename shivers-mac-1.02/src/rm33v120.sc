;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33120)
(include sci.sh)
(use Main)

(public
	rm33v120 0
)

(instance rm33v120 of ShiversRoom
	(properties
		picture 33120
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitPuzzle init: 3)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33140
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33150
	)
)

(instance efExitPuzzle of ExitFeature
	(properties
		nextRoom 33500
	)

	(method (init)
		(self createPoly: 166 80 219 80 219 123 165 123 165 80)
		(super init: &rest)
	)
)

