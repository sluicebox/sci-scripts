;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31250)
(include sci.sh)
(use Main)

(public
	rm31v250 0
)

(instance rm31v250 of ShiversRoom
	(properties
		picture 31250
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31230
	)

	(method (init)
		(self createPoly: 90 118 109 88 109 2 196 2 198 87 220 119 90 119)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31260
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31270
	)
)

