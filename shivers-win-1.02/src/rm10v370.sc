;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10370)
(include sci.sh)
(use Main)

(public
	rm10v370 0
)

(instance rm10v370 of ShiversRoom
	(properties
		picture 10370
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10200
	)

	(method (init)
		(self createPoly: 37 98 243 77 223 2 38 25)
		(super init: &rest)
	)
)

