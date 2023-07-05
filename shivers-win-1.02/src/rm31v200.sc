;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31200)
(include sci.sh)
(use Main)

(public
	rm31v200 0
)

(instance rm31v200 of ShiversRoom
	(properties
		picture 31200
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
		nextRoom 31120
	)

	(method (init)
		(self createPoly: 31 6 31 127 233 127 233 5 31 5)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31410
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31150
	)
)

