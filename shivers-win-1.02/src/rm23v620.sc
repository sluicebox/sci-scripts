;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23620)
(include sci.sh)
(use Main)

(public
	rm23v620 0
)

(instance rm23v620 of ShiversRoom
	(properties
		picture 23620
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23400
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23430
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23460
	)

	(method (init)
		(self
			createPoly:
				96
				124
				181
				124
				158
				100
				142
				100
				142
				89
				146
				71
				145
				59
				138
				54
				129
				54
				121
				62
				121
				81
				123
				97
				123
				99
				109
				99
				92
				124
		)
		(super init: &rest)
	)
)

