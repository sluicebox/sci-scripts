;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16280)
(include sci.sh)
(use Main)

(public
	rm16v280 0
)

(instance rm16v280 of ShiversRoom
	(properties
		picture 16280
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
		nextRoom 16270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16260
	)

	(method (init)
		(self
			createPoly: 107 142 131 120 131 88 111 57 29 54 29 11 154 12 154 62 240 127 240 143
		)
		(super init: &rest)
	)
)

