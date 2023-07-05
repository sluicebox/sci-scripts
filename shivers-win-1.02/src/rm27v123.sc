;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27123)
(include sci.sh)
(use Main)

(public
	rm27v123 0
)

(instance rm27v123 of ShiversRoom
	(properties
		picture 27123
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
		nextRoom 33020
	)

	(method (init)
		(self createPoly: 44 142 114 17 146 17 205 142 45 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27122
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27120
	)
)

