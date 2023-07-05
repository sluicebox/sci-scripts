;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23180)
(include sci.sh)
(use Main)

(public
	rm23v180 0
)

(instance rm23v180 of ShiversRoom
	(properties
		picture 23180
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23090
	)

	(method (init)
		(self createPoly: 198 51 198 107 236 102 236 51 198 51)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23210
	)
)

