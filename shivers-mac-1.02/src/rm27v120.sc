;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27120)
(include sci.sh)
(use Main)

(public
	rm27v120 0
)

(instance rm27v120 of ShiversRoom
	(properties
		picture 27120
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
		nextRoom 27130
	)

	(method (init)
		(self createPoly: 74 142 91 112 113 66 163 66 204 142 75 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27123
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27121
	)
)

