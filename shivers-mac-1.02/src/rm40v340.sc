;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40340)
(include sci.sh)
(use Main)

(public
	rm40v340 0
)

(instance rm40v340 of ShiversRoom
	(properties
		picture 40200
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
		nextRoom 40320
	)

	(method (init)
		(self
			createPoly: 24 143 42 117 80 100 117 93 180 5 258 5 258 109 194 121 194 142 26 142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40330
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40330
	)
)

