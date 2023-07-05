;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9170)
(include sci.sh)
(use Main)

(public
	rm9v17 0
)

(instance rm9v17 of ShiversRoom
	(properties
		picture 9170
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
		nextRoom 9160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9940
	)

	(method (init)
		(self createPoly: 90 105 90 22 194 22 194 105 206 141 83 141)
		(super init: &rest)
	)
)

