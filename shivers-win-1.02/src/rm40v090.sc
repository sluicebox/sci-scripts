;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40090)
(include sci.sh)
(use Main)

(public
	rm40v090 0
)

(instance rm40v090 of ShiversRoom
	(properties
		picture 40090
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
		nextRoom 40070
	)

	(method (init)
		(self
			createPoly:
				20
				125
				53
				109
				67
				113
				101
				100
				111
				107
				145
				99
				157
				105
				157
				1
				214
				1
				206
				126
				20
				126
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40080
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40080
	)
)

