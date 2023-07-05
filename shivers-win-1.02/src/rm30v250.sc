;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30250)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v250 0
)

(instance rm30v250 of ShiversRoom
	(properties
		picture 30251
	)

	(method (init)
		(proc951_16 112)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 30270
	)

	(method (init)
		(self
			createPoly:
				0
				0
				0
				40
				220
				40
				220
				100
				40
				100
				40
				42
				0
				42
				0
				142
				262
				142
				262
				0
				0
				0
		)
		(super init: &rest)
	)
)

