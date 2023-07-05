;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30300)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v300 0
)

(instance rm30v300 of ShiversRoom
	(properties
		picture 30300
	)

	(method (init)
		(if (IsFlag 85)
			(self picture: 30301)
		)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30290
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30360
	)

	(method (init)
		(self createPoly: 185 143 162 110 162 40 40 40 40 143 185 143)
		(super init: &rest)
	)
)

