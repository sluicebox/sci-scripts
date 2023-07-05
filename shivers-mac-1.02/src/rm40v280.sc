;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40280)
(include sci.sh)
(use Main)

(public
	rm40v280 0
)

(instance rm40v280 of ShiversRoom
	(properties
		picture 40250
	)

	(method (init)
		(efExitChains init: 3)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitChains of ExitFeature
	(properties
		nextRoom 40260
	)

	(method (init)
		(self createPoly: 23 1 23 142 78 104 71 2 24 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40250
	)

	(method (init)
		(self createPoly: 38 126 130 91 139 1 214 1 199 114 199 127 38 127)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40270
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40270
	)
)

