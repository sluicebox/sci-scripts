;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23380)
(include sci.sh)
(use Main)

(public
	rm23v380 0
)

(instance rm23v380 of ShiversRoom
	(properties
		picture 23380
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
		nextRoom 23680
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23670
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23430
	)

	(method (init)
		(self
			createPoly: 232 70 196 70 182 59 117 59 97 85 67 85 63 136 190 136 233 95 233 70
		)
		(super init: &rest)
	)
)

