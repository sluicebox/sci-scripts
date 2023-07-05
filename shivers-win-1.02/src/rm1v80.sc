;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1080)
(include sci.sh)
(use Main)

(public
	rm1v80 0
)

(instance rm1v80 of ShiversRoom
	(properties
		picture 1080
	)

	(method (init)
		(gSounds fade: 10111 0 1 40 1 0)
		(efExitStatue init: 4)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitStatue of ExitFeature
	(properties
		nextRoom 1084
	)

	(method (init)
		(self createPoly: 171 1 177 43 181 61 208 69 241 68 241 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1081
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1082
	)

	(method (init)
		(self
			createPoly:
				245
				1
				245
				68
				190
				75
				183
				130
				245
				130
				245
				243
				262
				243
				262
				1
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1090
	)

	(method (init)
		(self
			createPoly:
				1
				110
				81
				72
				75
				53
				79
				34
				95
				18
				111
				13
				129
				13
				144
				19
				156
				33
				162
				50
				162
				58
				146
				58
				138
				82
				56
				141
				1
				141
		)
		(super init: &rest)
	)
)

