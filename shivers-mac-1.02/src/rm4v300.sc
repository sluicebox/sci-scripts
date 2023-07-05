;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4300)
(include sci.sh)
(use Main)

(public
	rm4v300 0
)

(instance rm4v300 of ShiversRoom
	(properties
		picture 4080
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4280
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4280
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4360
	)

	(method (init)
		(self createPoly: 192 132 76 132 97 102 97 53 164 53 165 100)
		(super init: &rest)
	)
)

