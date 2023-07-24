;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9150)
(include sci.sh)
(use Main)

(public
	rm9v15 0
)

(instance rm9v15 of ShiversRoom
	(properties
		picture 9150
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9590
	)

	(method (init)
		(self
			createPoly: 69 142 94 120 107 93 104 37 161 37 161 94 175 123 211 142
		)
		(super init: &rest)
	)
)

