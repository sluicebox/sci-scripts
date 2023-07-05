;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24170)
(include sci.sh)
(use Main)
(use SkeletonDialPuzzle)

(public
	rm24v170 0
)

(instance rm24v170 of ShiversRoom
	(properties
		picture 24170
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(SkeletonDialPuzzle init: 0 0 10 2)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24070
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24100
	)

	(method (init)
		(self createPoly: 0 0 51 0 51 90 0 90 0 1)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 24810
	)

	(method (init)
		(self createPoly: 0 95 44 95 45 113 36 142 0 142 0 96)
		(super init: &rest)
	)
)

