;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9030)
(include sci.sh)
(use Main)

(public
	rm9v03 0
)

(instance rm9v03 of ShiversRoom
	(properties
		picture 9030
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
		nextRoom 9050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9010
	)

	(method (init)
		(self createPoly: 17 92 1 12 1 1 42 1 58 110)
		(super init: &rest)
	)
)

