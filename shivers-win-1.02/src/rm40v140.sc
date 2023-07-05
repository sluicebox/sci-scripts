;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40140)
(include sci.sh)
(use Main)

(public
	rm40v140 0
)

(instance rm40v140 of ShiversRoom
	(properties
		picture 40060
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40160
	)

	(method (init)
		(self createPoly: 81 126 230 126 185 93 143 78 143 1 76 1 82 125)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40150
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40150
	)
)

