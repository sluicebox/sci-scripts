;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27062)
(include sci.sh)
(use Main)

(public
	rm27v062 0
)

(instance rm27v062 of ShiversRoom
	(properties
		picture 27062
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
		nextRoom 27051
	)

	(method (init)
		(self createPoly: 85 142 120 59 140 59 174 142 86 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27061
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27063
	)
)

