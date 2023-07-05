;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1520)
(include sci.sh)
(use Main)

(public
	rm1v520 0
)

(instance rm1v520 of ShiversRoom
	(properties
		picture 1520
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
		nextRoom 1521
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1521
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1530
	)

	(method (init)
		(self
			createPoly:
				0
				140
				99
				43
				118
				47
				129
				45
				157
				1
				187
				1
				154
				57
				199
				69
				262
				141
		)
		(super init: &rest)
	)
)

