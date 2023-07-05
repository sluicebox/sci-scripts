;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17070)
(include sci.sh)
(use Main)

(public
	rm17v070 0
)

(instance rm17v070 of ShiversRoom
	(properties
		picture 17070
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
		nextRoom 17100
	)

	(method (init)
		(self createPoly: 0 0 75 0 75 143 0 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 17040
	)

	(method (init)
		(self createPoly: 107 143 107 1 142 1 147 138)
		(super init: &rest)
	)
)

