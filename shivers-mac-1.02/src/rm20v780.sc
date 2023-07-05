;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20780)
(include sci.sh)
(use Main)

(public
	rm20v780 0
)

(instance rm20v780 of ShiversRoom
	(properties
		picture 20780
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 20780
	)

	(method (init)
		(self createPoly: 51 5 149 5 149 140 55 140 55 5)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20670
	)

	(method (init)
		(self createPoly: 210 0 262 0 262 144 210 144 210 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20660
	)

	(method (init)
		(self createPoly: 0 0 50 0 50 144 0 144 0 0)
		(super init: &rest)
	)
)

