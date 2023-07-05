;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20450)
(include sci.sh)
(use Main)

(public
	rm20v450 0
)

(instance rm20v450 of ShiversRoom
	(properties
		picture 20450
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20400
	)

	(method (init)
		(self createPoly: 156 128 54 128 44 94 67 17 147 17 181 95)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20460
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20470
	)
)

