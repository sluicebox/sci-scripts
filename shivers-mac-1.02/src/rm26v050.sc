;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26050)
(include sci.sh)
(use Main)

(public
	rm26v050 0
)

(instance rm26v050 of ShiversRoom
	(properties
		picture 26050
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
		nextRoom 26040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26070
	)

	(method (init)
		(self createPoly: 227 142 227 139 173 68 21 69 21 144)
		(super init: &rest)
	)
)

