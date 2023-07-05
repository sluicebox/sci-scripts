;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30350)
(include sci.sh)
(use Main)

(public
	rm30v350 0
)

(instance rm30v350 of ShiversRoom
	(properties
		picture 30350
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30360
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30340
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 30330
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

