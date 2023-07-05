;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29060)
(include sci.sh)
(use Main)
(use n951)

(public
	rm29v060 0
)

(instance rm29v060 of ShiversRoom
	(properties
		picture 29061
	)

	(method (init)
		(if (IsFlag 61)
			(self picture: 29060)
		)
		(efExitPlaque init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForwardDoor init: 3)
		(if (IsFlag 69)
			(efExitSun init: 3)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29030
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 29810
	)

	(method (init)
		(self createPoly: 24 143 27 121 57 120 53 143)
		(super init: &rest)
	)
)

(instance efExitForwardDoor of ExitFeature
	(properties
		nextRoom 29070
	)

	(method (init)
		(self createPoly: 186 140 184 55 166 45 139 54 130 142 186 141)
		(super init: &rest)
	)
)

(instance efExitSun of ExitFeature
	(properties
		nextRoom 29260
	)

	(method (init)
		(self createPoly: 24 24 24 117 60 117 60 142 113 142 119 20 26 24)
		(super init: &rest)
	)
)

