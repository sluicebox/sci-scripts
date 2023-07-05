;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6200)
(include sci.sh)
(use Main)

(public
	rm6v200 0
)

(instance rm6v200 of ShiversRoom
	(properties
		picture 6200
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efMap init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6170
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6190
	)
)

(instance efMap of ExitFeature
	(properties
		nextRoom 6201
	)

	(method (init)
		(self createPoly: 58 15 58 107 211 107 211 14 58 14)
		(super init: &rest)
	)
)

