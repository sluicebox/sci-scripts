;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1430)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v430 0
)

(instance rm1v430 of ShiversRoom
	(properties
		picture 1430
	)

	(method (init)
		(proc951_9 10111)
		(gSounds play: 10111 -1 0 0)
		(gSounds fade: 10111 98 1 40 0 0)
		(gSounds fade: 10112 0 1 40 1 0)
		(efExitForward init: 9)
		(efExitForwardLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1420
	)

	(method (init)
		(self
			createPoly: 0 142 77 98 105 98 105 42 170 68 168 99 185 99 245 141
		)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 1423
	)

	(method (init)
		(self createPoly: 0 142 0 6 58 6 58 109)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1421
	)
)

