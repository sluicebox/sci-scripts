;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15040)
(include sci.sh)
(use Main)

(public
	rm15v4 0
)

(instance rm15v4 of ShiversRoom
	(properties
		picture 15040
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
		nextRoom 15010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 15060
	)

	(method (init)
		(self
			createPoly:
				92
				90
				94
				81
				94
				62
				98
				49
				99
				46
				106
				44
				117
				42
				132
				44
				142
				47
				140
				59
				139
				76
				143
				89
				141
				98
				131
				105
				107
				102
				99
				101
				92
				96
		)
		(super init: &rest)
	)
)

