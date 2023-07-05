;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27021)
(include sci.sh)
(use Main)

(public
	rm27v021 0
)

(instance rm27v021 of ShiversRoom
	(properties
		picture 27024
	)

	(method (init)
		(efExitDown init: 5)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 27024
	)

	(method (init)
		(self createPoly: 59 142 59 108 201 108 201 142 60 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 210
		nextRoom 27020
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 50
		nextRoom 27022
	)
)

