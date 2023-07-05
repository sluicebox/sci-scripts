;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27010)
(include sci.sh)
(use Main)

(public
	rm27v010 0
)

(instance rm27v010 of ShiversRoom
	(properties
		picture 27010
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27020
	)

	(method (init)
		(self createPoly: 82 142 116 52 143 52 168 142 82 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27013
	)
)

(instance efExitLeft of ExitFeature ; UNUSED
	(properties
		nextRoom 27011
	)
)

