;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3170)
(include sci.sh)
(use Main)

(public
	rm3v170 0
)

(instance rm3v170 of ShiversRoom
	(properties
		picture 3170
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(gPBoatView setView: 2)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3180
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 3040
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

