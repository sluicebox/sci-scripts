;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32560)
(include sci.sh)
(use Main)

(public
	rm32v560 0
)

(instance rm32v560 of ShiversRoom
	(properties
		picture 32560
	)

	(method (init)
		(efExitUp init: 4)
		(efExitDown init: 3)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 32072
	)

	(method (init)
		(self createPoly: 263 0 263 35 0 35 0 0 263 0)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 32570
	)

	(method (init)
		(self
			createPoly: 73 116 98 100 111 92 118 55 187 55 192 58 197 116 74 116
		)
		(super init: &rest)
	)
)

