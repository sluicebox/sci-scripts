;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29280)
(include sci.sh)
(use Main)

(public
	rm29v280 0
)

(instance rm29v280 of ShiversRoom
	(properties
		picture 29280
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 29160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 29150
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 26010
	)

	(method (init)
		(self
			createPoly:
				103
				131
				110
				63
				117
				41
				127
				32
				138
				30
				154
				35
				163
				50
				170
				129
				103
				131
		)
		(super init: &rest)
	)
)

