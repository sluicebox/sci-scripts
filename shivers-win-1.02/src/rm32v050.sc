;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32050)
(include sci.sh)
(use Main)

(public
	rm32v050 0
)

(instance rm32v050 of ShiversRoom
	(properties
		picture 32050
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
		nextRoom 32040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32070
	)

	(method (init)
		(self createPoly: 44 116 44 51 97 51 97 118 47 118)
		(super init: &rest)
	)
)

