;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40250)
(include sci.sh)
(use Main)

(public
	rm40v250 0
)

(instance rm40v250 of ShiversRoom
	(properties
		picture 40310
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40230
	)

	(method (init)
		(self createPoly: 200 142 222 4 145 4 118 104 85 113 43 142 199 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40240
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40260
	)
)

