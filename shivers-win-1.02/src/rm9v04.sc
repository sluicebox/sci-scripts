;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9040)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v04 0
)

(instance rm9v04 of ShiversRoom
	(properties
		picture 9040
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 10918 0 40 0)
			(ClearFlag 43)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efPlaque init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9760
	)

	(method (init)
		(self createPoly: 56 4 196 40 199 139 82 134 103 113 85 89 54 89)
		(super init: &rest)
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 9810
	)

	(method (init)
		(self createPoly: 77 93 44 95 44 109 60 142 79 142 74 115 97 112)
		(super init: &rest)
	)
)

