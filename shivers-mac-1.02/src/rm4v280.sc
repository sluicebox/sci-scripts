;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4280)
(include sci.sh)
(use Main)

(public
	rm4v280 0
)

(instance rm4v280 of ShiversRoom
	(properties
		picture 4010
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4300
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4300
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4230
	)

	(method (init)
		(self createPoly: 84 117 100 100 100 62 153 62 158 96 175 115)
		(super init: &rest)
	)
)

