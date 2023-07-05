;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35210)
(include sci.sh)
(use Main)

(public
	rm35v210 0
)

(instance rm35v210 of ShiversRoom
	(properties
		picture 35210
	)

	(method (init)
		(efExitDown init: 5)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35190
	)

	(method (init)
		(self createPoly: 89 114 89 67 97 47 155 47 164 69 165 113 89 114)
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
				98
				143
				95
				135
				156
				130
				162
				118
				166
				117
				189
				127
				185
				143
				98
				143
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35240
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35250
	)
)

