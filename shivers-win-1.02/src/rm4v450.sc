;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4450)
(include sci.sh)
(use Main)

(public
	rm4v450 0
)

(instance rm4v450 of ShiversRoom
	(properties
		picture 4120
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 71
		nextRoom 4440
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4460
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4490
	)

	(method (init)
		(self createPoly: 84 117 100 100 100 62 153 62 158 96 175 115)
		(super init: &rest)
	)
)

