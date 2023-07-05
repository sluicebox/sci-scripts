;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23150)
(include sci.sh)
(use Main)

(public
	rm23v150 0
)

(instance rm23v150 of ShiversRoom
	(properties
		picture 23150
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23170
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23080
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

