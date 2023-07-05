;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20720)
(include sci.sh)
(use Main)

(public
	rm20v720 0
)

(instance rm20v720 of ShiversRoom
	(properties
		picture 20720
	)

	(method (init)
		(efExitUp init: 4)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 20270
	)

	(method (init)
		(self createPoly: 34 0 34 38 224 38 224 0 35 0)
		(super init: &rest)
	)
)

