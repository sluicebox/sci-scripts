;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23170)
(include sci.sh)
(use Main)

(public
	rm23v170 0
)

(instance rm23v170 of ShiversRoom
	(properties
		picture 23170
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23160
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 23150
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

