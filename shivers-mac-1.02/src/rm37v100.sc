;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37100)
(include sci.sh)
(use Main)

(public
	rm37v100 0
)

(instance rm37v100 of ShiversRoom
	(properties
		picture 37100
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37120
	)

	(method (init)
		(self createPoly: 71 135 74 102 89 89 91 43 113 41 119 115)
		(super init: &rest)
	)
)

