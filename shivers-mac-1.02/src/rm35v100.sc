;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35100)
(include sci.sh)
(use Main)

(public
	rm35v100 0
)

(instance rm35v100 of ShiversRoom
	(properties
		picture 35100
	)

	(method (init)
		(efExitForward init: 3)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35110
	)

	(method (init)
		(self createPoly: 0 0 0 112 228 114 264 99 264 0 0 0)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 40380
	)

	(method (init)
		(self createPoly: 0 144 0 112 228 114 264 99 264 144 0 144)
		(super init: &rest)
	)
)

