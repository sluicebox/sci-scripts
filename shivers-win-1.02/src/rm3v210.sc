;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3210)
(include sci.sh)
(use Main)

(public
	rm3v210 0
)

(instance rm3v210 of ShiversRoom
	(properties
		picture 3210
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
		nextRoom 3200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3220
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

