;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1230)
(include sci.sh)
(use Main)

(public
	rm1v230 0
)

(instance rm1v230 of ShiversRoom
	(properties
		picture 1230
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1231
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1231
	)

	(method (init)
		(self createPoly: 240 0 240 103 262 108 262 0 240 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1240
	)

	(method (init)
		(self
			createPoly:
				23
				143
				50
				113
				101
				89
				155
				82
				207
				88
				261
				111
				261
				143
				213
				143
				190
				134
				166
				135
				157
				144
		)
		(super init: &rest)
	)
)

