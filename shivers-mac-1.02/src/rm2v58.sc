;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2580)
(include sci.sh)
(use Main)

(public
	rm2v58 0
)

(instance rm2v58 of ShiversRoom
	(properties
		picture 2580
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
		nextRoom 2590
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2590
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2560
	)

	(method (init)
		(self
			createPoly:
				55
				143
				99
				96
				99
				57
				113
				43
				123
				53
				139
				53
				155
				34
				181
				47
				189
				58
				190
				123
				208
				143
		)
		(super init: &rest)
	)
)

