;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30260)
(include sci.sh)
(use Main)

(public
	rm30v260 0
)

(instance rm30v260 of ShiversRoom
	(properties
		picture 30260
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30250
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30290
	)

	(method (init)
		(self
			createPoly:
				57
				84
				56
				130
				118
				130
				118
				135
				198
				135
				198
				42
				123
				42
				123
				76
				74
				76
				58
				83
		)
		(super init: &rest)
	)
)

