;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32370)
(include sci.sh)
(use Main)

(public
	rm32v370 0
)

(instance rm32v370 of ShiversRoom
	(properties
		picture 32370
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32420
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32430
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32074
	)

	(method (init)
		(self
			createPoly: 184 133 184 75 170 75 152 41 106 41 84 75 62 75 62 132 182 132
		)
		(super init: &rest)
	)
)

