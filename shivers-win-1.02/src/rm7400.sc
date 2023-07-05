;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7400)
(include sci.sh)
(use Main)

(public
	rm7400 0
)

(instance rm7400 of ShiversRoom
	(properties
		picture 7400
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7130
	)

	(method (init)
		(self createPoly: 57 1 57 140 210 140 210 2 57 2)
		(super init: &rest)
	)
)

