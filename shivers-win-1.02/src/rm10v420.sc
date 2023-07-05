;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10420)
(include sci.sh)
(use Main)

(public
	rm10v420 0
)

(instance rm10v420 of ShiversRoom
	(properties
		picture 10420
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10490
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10430
	)

	(method (init)
		(self
			createPoly:
				83
				138
				98
				114
				89
				95
				82
				87
				75
				58
				87
				45
				114
				26
				149
				23
				176
				36
				187
				50
				192
				69
				192
				92
				181
				104
				172
				114
				186
				137
		)
		(super init: &rest)
	)
)

