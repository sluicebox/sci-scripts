;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1082)
(include sci.sh)
(use Main)

(public
	rm1v82 0
)

(instance rm1v82 of ShiversRoom
	(properties
		picture 1082
	)

	(method (init)
		(gSounds stop: 10111)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitUp init: 4)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1080
	)

	(method (init)
		(self
			createPoly:
				50
				1
				49
				79
				81
				85
				81
				103
				72
				112
				72
				122
				86
				121
				88
				127
				55
				143
				0
				141
				0
				1
				50
				1
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1081
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1101
	)

	(method (init)
		(self
			createPoly:
				61
				143
				91
				130
				87
				117
				72
				119
				71
				112
				84
				105
				83
				94
				108
				95
				138
				101
				181
				128
				184
				144
				61
				143
		)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 1092
	)

	(method (init)
		(self createPoly: 61 1 61 45 241 45 241 1)
		(super init: &rest)
	)
)

