;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40040)
(include sci.sh)
(use Main)

(public
	rm40v040 0
)

(instance rm40v040 of ShiversRoom
	(properties
		picture 40030
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
		nextRoom 40060
	)

	(method (init)
		(self createPoly: 96 126 237 126 173 87 151 1 95 1 94 126 96 126)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40050
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40050
	)
)

