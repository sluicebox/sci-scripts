;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27063)
(include sci.sh)
(use Main)

(public
	rm27v063 0
)

(instance rm27v063 of ShiversRoom
	(properties
		picture 27063
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
		nextRoom 27073
	)

	(method (init)
		(self createPoly: 77 143 112 55 137 55 168 142 78 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27062
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27060
	)
)

