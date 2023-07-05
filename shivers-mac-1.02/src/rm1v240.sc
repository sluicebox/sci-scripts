;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1240)
(include sci.sh)
(use Main)

(public
	rm1v240 0
)

(instance rm1v240 of ShiversRoom
	(properties
		picture 1240
	)

	(method (init)
		(gSounds fade: 10111 0 1 40 1 0)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1241
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1241
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1250
	)

	(method (init)
		(self
			createPoly:
				23
				125
				62
				70
				112
				48
				177
				48
				223
				56
				238
				100
				202
				78
				158
				75
				159
				93
				205
				113
				194
				144
				24
				143
		)
		(super init: &rest)
	)
)

