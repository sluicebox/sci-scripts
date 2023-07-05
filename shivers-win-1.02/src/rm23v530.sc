;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23530)
(include sci.sh)
(use Main)

(public
	rm23v530 0
)

(instance rm23v530 of ShiversRoom
	(properties
		picture 23530
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23570
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23540
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 23900
	)

	(method (init)
		(self createPoly: 221 94 247 96 245 106 218 104 220 94)
		(super init: &rest)
	)
)

