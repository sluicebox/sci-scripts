;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31400)
(include sci.sh)
(use Main)

(public
	rm31v400 0
)

(instance rm31v400 of ShiversRoom
	(properties
		picture 31400
	)

	(method (init)
		(efExitUp init: 4)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 31210
	)

	(method (init)
		(self createPoly: 22 0 22 32 231 32 231 0 23 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31240
	)

	(method (init)
		(self createPoly: 42 116 103 116 103 32 39 32 39 116 42 116)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31220
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31180
	)
)

