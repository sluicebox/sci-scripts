;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9050)
(include sci.sh)
(use Main)

(public
	rm9v05 0
)

(instance rm9v05 of ShiversRoom
	(properties
		picture 9050
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9750
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9760
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9110
	)

	(method (init)
		(self createPoly: 65 108 106 97 106 70 167 70 167 108 160 125)
		(super init: &rest)
	)
)

