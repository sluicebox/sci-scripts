;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1451)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v451 0
)

(instance rm1v451 of ShiversRoom
	(properties
		picture 1451
	)

	(method (init)
		(proc951_9 10111)
		(gSounds play: 10111 -1 0 0)
		(gSounds fade: 10111 98 1 40 0 0)
		(gSounds fade: 10112 0 1 40 1 0)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1450
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1450
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1421
	)

	(method (init)
		(self createPoly: 1 142 1 128 88 82 80 34 193 34 182 84 264 118 264 142)
		(super init: &rest)
	)
)

