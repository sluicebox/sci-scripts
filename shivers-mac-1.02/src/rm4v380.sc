;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4380)
(include sci.sh)
(use Main)

(public
	rm4v380 0
)

(instance rm4v380 of ShiversRoom
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
		nextRoom 4390
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4390
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4350
	)

	(method (init)
		(self createPoly: 201 134 57 134 83 107 83 20 166 20 166 100)
		(super init: &rest)
	)
)

