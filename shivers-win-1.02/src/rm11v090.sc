;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11090)
(include sci.sh)
(use Main)

(public
	rm11v090 0
)

(instance rm11v090 of ShiversRoom
	(properties
		picture 11090
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11120
	)

	(method (init)
		(self
			createPoly:
				40
				143
				57
				95
				54
				90
				44
				90
				44
				45
				174
				45
				165
				117
				200
				118
				211
				144
		)
		(super init: &rest)
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 11420
	)

	(method (init)
		(self createPoly: 27 90 19 95 15 105 28 108 28 143 40 143 58 93 55 90)
		(super init: &rest)
	)
)

