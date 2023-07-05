;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30400)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v400 0
)

(instance rm30v400 of ShiversRoom
	(properties
		picture 30400
	)

	(method (init)
		(if (IsFlag 85)
			(self picture: 30401)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30370
	)

	(method (init)
		(self createPoly: 1 1 40 1 40 143 1 143 1 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30390
	)

	(method (init)
		(self createPoly: 262 1 262 143 240 143 230 133 230 1 262 1)
		(super init: &rest)
	)
)

