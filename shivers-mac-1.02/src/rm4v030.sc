;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4030)
(include sci.sh)
(use Main)

(public
	rm4v030 0
)

(instance rm4v030 of ShiversRoom
	(properties
		picture 4010
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4060
	)

	(method (init)
		(self createPoly: 201 134 57 134 83 107 83 20 166 20 166 100)
		(super init: &rest)
	)
)

