;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35320)
(include sci.sh)
(use Main)

(public
	rm35v320 0
)

(instance rm35v320 of ShiversRoom
	(properties
		picture 35320
	)

	(method (init)
		(efExitForwardLeft init: 3)
		(efExitForwardRight init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 35401
	)

	(method (init)
		(self
			createPoly:
				72
				137
				82
				126
				79
				115
				84
				112
				140
				112
				152
				114
				168
				138
				72
				137
		)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 35160
	)

	(method (init)
		(self createPoly: 88 101 61 95 62 68 94 65 123 72 121 98 98 104 88 101)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 35150
	)

	(method (init)
		(self
			createPoly:
				143
				97
				142
				77
				147
				62
				165
				51
				182
				61
				190
				73
				185
				98
				179
				100
				143
				97
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35290
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35280
	)
)

