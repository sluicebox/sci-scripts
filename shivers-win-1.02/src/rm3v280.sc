;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3280)
(include sci.sh)
(use Main)

(public
	rm3v280 0
)

(instance rm3v280 of ShiversRoom
	(properties
		picture 3280
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(gPBoatView setView: 1 nextRoom: 3240)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3310
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3290
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

