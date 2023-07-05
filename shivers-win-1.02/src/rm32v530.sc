;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32530)
(include sci.sh)
(use Main)

(public
	rm32v530 0
)

(instance rm32v530 of ShiversRoom
	(properties
		picture 32530
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32520
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32490
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32540
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

