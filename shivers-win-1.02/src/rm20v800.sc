;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20800)
(include sci.sh)
(use Main)

(public
	rm20v800 0
)

(instance rm20v800 of ShiversRoom
	(properties
		picture 20800
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 20800
	)

	(method (init)
		(self createPoly: 51 5 149 5 149 140 55 140 55 5)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20610
	)

	(method (init)
		(self createPoly: 200 0 262 0 262 144 200 144 200 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20600
	)

	(method (init)
		(self createPoly: 0 0 60 0 60 144 0 144 0 0)
		(super init: &rest)
	)
)

