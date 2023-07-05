;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13014)
(include sci.sh)
(use Main)

(public
	rm13v014 0
)

(instance rm13v014 of ShiversRoom
	(properties
		picture 13150
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13017
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13016
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13436
	)

	(method (init)
		(self createPoly: 112 92 112 50 150 50 150 93)
		(super init: &rest)
	)
)

