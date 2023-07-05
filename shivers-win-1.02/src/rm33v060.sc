;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33060)
(include sci.sh)
(use Main)
(use n951)

(public
	rm33v060 0
)

(instance rm33v060 of ShiversRoom
	(properties
		picture 33060
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(if (IsFlag 43)
			(ClearFlag 43)
			(gSounds play: 13012 0 82 0)
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33130
	)

	(method (init)
		(self createPoly: 83 141 214 141 214 4 82 4 82 141)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33240
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33240
	)
)

