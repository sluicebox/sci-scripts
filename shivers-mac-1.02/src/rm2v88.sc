;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2880)
(include sci.sh)
(use Main)

(public
	rm2v88 0
)

(instance rm2v88 of ShiversRoom
	(properties
		picture 2290
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2860
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2870
	)

	(method (init)
		(self
			createPoly:
				66
				143
				100
				123
				138
				112
				182
				105
				179
				105
				179
				0
				263
				0
				263
				142
		)
		(super init: &rest)
	)
)

