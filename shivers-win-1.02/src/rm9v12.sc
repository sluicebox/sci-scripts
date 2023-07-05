;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9120)
(include sci.sh)
(use Main)

(public
	rm9v12 0
)

(instance rm9v12 of ShiversRoom
	(properties
		picture 9120
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
		nextRoom 9150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9130
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9090
	)

	(method (init)
		(self createPoly: 67 139 98 105 98 44 195 44 195 142 63 144 66 140)
		(super init: &rest)
	)
)

