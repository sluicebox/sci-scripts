;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14050)
(include sci.sh)
(use Main)

(public
	rm14v5 0
)

(instance rm14v5 of ShiversRoom
	(properties
		picture 14050
	)

	(method (init)
		(efExitForwardRight init: 1)
		(efTurnAround init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 14270
	)

	(method (init)
		(self createPoly: 193 126 185 98 186 32 243 32 243 126 193 126)
		(super init: &rest)
	)
)

(instance efTurnAround of ExitFeature
	(properties
		nextRoom 14060
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14060
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14030
	)

	(method (init)
		(self
			createPoly: 113 122 129 103 130 30 154 21 169 22 186 32 185 97 192 125
		)
		(super init: &rest)
	)
)

