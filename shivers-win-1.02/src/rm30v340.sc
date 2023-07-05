;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30340)
(include sci.sh)
(use Main)

(public
	rm30v340 0
)

(instance rm30v340 of ShiversRoom
	(properties
		picture 30340
	)

	(method (init)
		(efExitTrunk init: 3)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30350
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30330
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30280
	)

	(method (init)
		(self createPoly: 82 130 189 130 162 102 162 52 92 52 85 52 85 130)
		(super init: &rest)
	)
)

(instance efExitTrunk of ExitFeature
	(properties
		nextRoom 30290
	)

	(method (init)
		(self createPoly: 0 84 47 80 47 117 0 143 0 85)
		(super init: &rest)
	)
)

