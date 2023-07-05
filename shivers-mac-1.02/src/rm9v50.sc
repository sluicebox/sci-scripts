;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9500)
(include sci.sh)
(use Main)

(public
	rm9v50 0
)

(instance rm9v50 of ShiversRoom
	(properties
		picture 9500
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
		nextRoom 9510
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9510
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9480
	)

	(method (init)
		(self
			createPoly: 0 110 77 89 164 92 211 111 235 106 263 97 263 141 0 141
		)
		(super init: &rest)
	)
)

