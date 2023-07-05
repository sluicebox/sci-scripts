;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2470)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v47 0
)

(instance rm2v47 of ShiversRoom
	(properties
		picture 2470
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2471)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2350
	)

	(method (init)
		(self createPoly: 0 0 60 0 60 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2050
	)

	(method (init)
		(self createPoly: 200 0 262 0 262 144 200 144 200 0)
		(super init: &rest)
	)
)

