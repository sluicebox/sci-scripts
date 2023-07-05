;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13602)
(include sci.sh)
(use Main)

(public
	rm13v602 0
)

(instance rm13v602 of ShiversRoom
	(properties
		picture 13211
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13436
	)

	(method (init)
		(self createPoly: 103 97 103 45 132 49 133 92)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13018
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13019
	)
)

