;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40060)
(include sci.sh)
(use Main)

(public
	rm40v060 0
)

(instance rm40v060 of ShiversRoom
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
		nextRoom 40080
	)

	(method (init)
		(self createPoly: 82 125 75 0 141 0 141 78 230 126 82 126)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40070
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40070
	)
)

