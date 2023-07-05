;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1442)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v442 0
)

(instance rm1v442 of ShiversRoom
	(properties
		picture 1442
	)

	(method (init)
		(proc951_9 10112)
		(gSounds play: 10112 -1 0 0)
		(gSounds fade: 10112 98 1 40 0 0)
		(gSounds fade: 10111 0 1 40 1 0)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1441
	)

	(method (init)
		(self createPoly: 0 0 81 0 81 142 0 142 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1440
	)

	(method (init)
		(self createPoly: 195 0 262 0 262 143 195 143 195 0)
		(super init: &rest)
	)
)

