;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7410)
(include sci.sh)
(use Main)

(public
	rm7410 0
)

(instance rm7410 of ShiversRoom
	(properties
		picture 7410
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
		nextRoom 7120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 194
		nextRoom 7111
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7080
	)

	(method (init)
		(self createPoly: 66 35 66 97 106 100 75 141 154 141 154 33 66 33)
		(super init: &rest)
	)
)

