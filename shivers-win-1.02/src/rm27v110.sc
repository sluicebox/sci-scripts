;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27110)
(include sci.sh)
(use Main)

(public
	rm27v110 0
)

(instance rm27v110 of ShiversRoom
	(properties
		picture 27110
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27120
	)

	(method (init)
		(self createPoly: 44 142 65 94 109 56 159 56 214 96 241 142 44 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27111
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27111
	)
)

