;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11330)
(include sci.sh)
(use Main)
(use n951)
(use SkeletonDialPuzzle)

(public
	rm11v330 0
)

(instance rm11v330 of ShiversRoom
	(properties
		picture 11330
	)

	(method (init)
		(efExitBack init: 8)
		(SkeletonDialPuzzle init: 0 0 10 0)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 11107 0 64 0)
			(ClearFlag 43)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 11120
	)

	(method (init)
		(self
			createPoly: 0 143 0 0 263 0 263 143 126 143 126 123 243 123 243 20 20 20 20 123 125 123 125 143
		)
		(super init: &rest)
	)
)

