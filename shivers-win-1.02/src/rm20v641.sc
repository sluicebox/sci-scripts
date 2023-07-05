;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20641)
(include sci.sh)
(use Main)

(public
	rm20v641 0
)

(instance rm20v641 of ShiversRoom
	(properties
		picture 20641
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 20610
	)

	(method (init)
		(self createPoly: 25 4 28 141 161 128 161 4 26 4)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20630
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20620
	)
)

