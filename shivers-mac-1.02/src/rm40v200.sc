;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40200)
(include sci.sh)
(use Main)

(public
	rm40v200 0
)

(instance rm40v200 of ShiversRoom
	(properties
		picture 40040
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
		nextRoom 40220
	)

	(method (init)
		(self createPoly: 82 125 75 0 141 0 141 78 230 126 82 126)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40210
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40210
	)
)

