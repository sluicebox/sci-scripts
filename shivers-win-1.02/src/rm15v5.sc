;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15050)
(include sci.sh)
(use Main)

(public
	rm15v5 0
)

(instance rm15v5 of ShiversRoom
	(properties
		picture 15050
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15020
	)

	(method (init)
		(self createPoly: 111 98 111 46 162 46 162 98)
		(super init: &rest)
	)
)

