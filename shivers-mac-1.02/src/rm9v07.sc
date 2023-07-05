;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9070)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v07 0
)

(instance rm9v07 of ShiversRoom
	(properties
		picture 9070
	)

	(method (init)
		(proc951_16 95)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitDoor init: 3)
		(efExitMasks init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9100
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 9470
	)

	(method (init)
		(self createPoly: 243 105 226 106 225 9 243 11)
		(super init: &rest)
	)
)

(instance efExitMasks of ExitFeature
	(properties
		nextRoom 9040
	)

	(method (init)
		(self createPoly: 21 0 40 0 44 143 21 143)
		(super init: &rest)
	)
)

