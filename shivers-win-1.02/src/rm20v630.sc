;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20630)
(include sci.sh)
(use Main)

(public
	rm20v630 0
)

(instance rm20v630 of ShiversRoom
	(properties
		picture 20630
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20650
	)

	(method (init)
		(self createPoly: 171 1 211 1 210 140 135 140 171 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20620
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20641
	)
)

