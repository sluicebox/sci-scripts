;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8050)
(include sci.sh)
(use Main)

(public
	rm8v050 0
)

(instance rm8v050 of ShiversRoom
	(properties
		picture 8050
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
		nextRoom 8110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8170
	)

	(method (init)
		(self
			createPoly:
				70
				88
				70
				123
				49
				142
				230
				142
				230
				125
				241
				125
				241
				17
				216
				17
				71
				19
				69
				87
		)
		(super init: &rest)
	)
)

