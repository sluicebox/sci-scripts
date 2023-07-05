;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2310)
(include sci.sh)
(use Main)

(public
	rm2v31 0
)

(instance rm2v31 of ShiversRoom
	(properties
		picture 2310
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2620
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2330
	)

	(method (init)
		(self
			createPoly:
				42
				143
				93
				89
				112
				89
				112
				55
				118
				47
				125
				44
				132
				44
				137
				48
				144
				57
				144
				88
				163
				88
				212
				142
		)
		(super init: &rest)
	)
)

