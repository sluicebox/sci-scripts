;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31240)
(include sci.sh)
(use Main)

(public
	rm31v240 0
)

(instance rm31v240 of ShiversRoom
	(properties
		picture 31240
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31260
	)

	(method (init)
		(self
			createPoly: 79 4 153 8 146 66 135 74 139 85 146 85 145 98 87 90 79 5
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31230
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31230
	)
)

