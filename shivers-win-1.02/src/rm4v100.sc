;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4100)
(include sci.sh)
(use Main)

(public
	rm4v100 0
)

(instance rm4v100 of ShiversRoom
	(properties
		picture 4080
	)

	(method (init)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4120
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4070
	)

	(method (init)
		(self createPoly: 84 117 100 100 100 62 153 62 158 96 175 115)
		(super init: &rest)
	)
)

