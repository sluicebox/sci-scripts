;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1441)
(include sci.sh)
(use Main)

(public
	rm1v441 0
)

(instance rm1v441 of ShiversRoom
	(properties
		picture 1441
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1440
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1443
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1381
	)

	(method (init)
		(self createPoly: 30 133 74 110 67 66 171 27 167 72 181 105 235 121)
		(super init: &rest)
	)
)

