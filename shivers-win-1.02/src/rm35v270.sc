;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35270)
(include sci.sh)
(use Main)

(public
	rm35v270 0
)

(instance rm35v270 of ShiversRoom
	(properties
		picture 35270
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35190
	)

	(method (init)
		(self createPoly: 78 143 202 141 202 45 195 17 97 0 77 45 77 143)
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
		nextRoom 35150
	)
)

