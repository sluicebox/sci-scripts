;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1450)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v450 0
)

(instance rm1v450 of ShiversRoom
	(properties
		picture 1450
	)

	(method (init)
		(proc951_9 10112)
		(gSounds play: 10112 -1 0 0)
		(gSounds fade: 10112 98 1 40 0 0)
		(gSounds fade: 10111 0 1 40 1 0)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1451
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1451
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1460
	)

	(method (init)
		(self
			createPoly: 0 143 0 135 101 120 102 89 153 89 157 120 243 135 246 141
		)
		(super init: &rest)
	)
)

