;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40310)
(include sci.sh)
(use Main)

(public
	rm40v310 0
)

(instance rm40v310 of ShiversRoom
	(properties
		picture 40210
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40330
	)

	(method (init)
		(self createPoly: 13 4 36 97 152 97 152 4 13 4)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40320
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40320
	)
)

