;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9910)
(include sci.sh)
(use Main)

(public
	rm9v910 0
)

(instance rm9v910 of ShiversRoom
	(properties
		picture 9910
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 5)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9890
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9880
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9900
	)

	(method (init)
		(self createPoly: 20 80 245 80 245 141 20 141 20 80)
		(super init: &rest)
	)
)

