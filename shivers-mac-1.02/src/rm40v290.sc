;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40290)
(include sci.sh)
(use Main)

(public
	rm40v290 0
)

(instance rm40v290 of ShiversRoom
	(properties
		picture 40230
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40310
	)

	(method (init)
		(self
			createPoly: 50 142 68 127 68 2 140 2 140 85 199 96 237 118 237 142 50 142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40300
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40300
	)
)

