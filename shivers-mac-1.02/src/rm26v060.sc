;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26060)
(include sci.sh)
(use Main)

(public
	rm26v060 0
)

(instance rm26v060 of ShiversRoom
	(properties
		picture 26060
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26040
	)

	(method (init)
		(self createPoly: 155 143 155 34 150 23 117 11 83 9 37 17 21 25 21 144)
		(super init: &rest)
	)
)

