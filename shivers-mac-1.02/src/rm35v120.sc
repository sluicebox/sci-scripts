;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35120)
(include sci.sh)
(use Main)

(public
	rm35v120 0
)

(instance rm35v120 of ShiversRoom
	(properties
		picture 35120
	)

	(method (init)
		(efExitDown init: 5)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 35100
	)

	(method (init)
		(self createPoly: 39 143 39 118 223 118 223 142 40 142)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35190
	)

	(method (init)
		(self createPoly: 83 106 83 53 91 25 170 21 177 59 177 107 83 107)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35200
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35130
	)
)

