;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31520)
(include sci.sh)
(use Main)

(public
	rm31v520 0
)

(instance rm31v520 of ShiversRoom
	(properties
		picture 31520
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31150
	)

	(method (init)
		(self createPoly: 80 20 180 20 180 120 80 120 80 20)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31411
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31411
	)
)

