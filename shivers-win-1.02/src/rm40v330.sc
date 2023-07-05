;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40330)
(include sci.sh)
(use Main)

(public
	rm40v330 0
)

(instance rm40v330 of ShiversRoom
	(properties
		picture 40190
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
		nextRoom 40350
	)

	(method (init)
		(self createPoly: 38 1 52 123 59 123 97 112 79 1 38 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40340
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40340
	)
)

