;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23650)
(include sci.sh)
(use Main)
(use SkeletonDialPuzzle)

(public
	rm23v650 0
)

(instance rm23v650 of ShiversRoom
	(properties
		picture 23650
	)

	(method (init)
		(SkeletonDialPuzzle init: 0 0 10 5)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23660
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23660
	)
)

