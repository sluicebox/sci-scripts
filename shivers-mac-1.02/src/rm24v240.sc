;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24240)
(include sci.sh)
(use Main)

(public
	rm24v240 0
)

(instance rm24v240 of ShiversRoom
	(properties
		picture 24240
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 24230
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 24260
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 24800
	)

	(method (init)
		(self
			createPoly: 212 104 220 142 234 142 233 121 246 121 237 103 212 103
		)
		(super init: &rest)
	)
)

