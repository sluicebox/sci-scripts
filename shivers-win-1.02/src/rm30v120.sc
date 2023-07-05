;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30120)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v120 0
)

(instance rm30v120 of ShiversRoom
	(properties
		picture 30120
	)

	(method (init)
		(if (IsFlag 85)
			(self picture: 30121)
		)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30110
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30160
	)

	(method (init)
		(self createPoly: 70 141 94 120 94 54 181 54 183 131 191 141 70 141)
		(super init: &rest)
	)
)

