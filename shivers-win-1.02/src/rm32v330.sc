;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32330)
(include sci.sh)
(use Main)

(public
	rm32v330 0
)

(instance rm32v330 of ShiversRoom
	(properties
		picture 32330
	)

	(method (init)
		(efExitForward init: 3)
		(efExitForwardLeft init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32400
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32320
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32340
	)

	(method (init)
		(self createPoly: 93 140 99 83 106 34 193 34 193 140 93 140)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 32310
	)

	(method (init)
		(self createPoly: 22 40 90 40 90 140 22 140 22 40)
		(super init: &rest)
	)
)

