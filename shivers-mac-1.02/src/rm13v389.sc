;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13389)
(include sci.sh)
(use Main)

(public
	rm13v389 0
)

(instance rm13v389 of ShiversRoom
	(properties
		picture 13310
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
		nextRoom 13388
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13388
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13387
	)

	(method (init)
		(self createPoly: 71 143 97 112 97 40 162 40 162 102 201 142)
		(super init: &rest)
	)
)

