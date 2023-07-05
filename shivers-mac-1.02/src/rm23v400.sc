;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23400)
(include sci.sh)
(use Main)

(public
	rm23v400 0
)

(instance rm23v400 of ShiversRoom
	(properties
		picture 23400
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23390
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23620
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23370
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

