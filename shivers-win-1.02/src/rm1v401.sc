;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1401)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v401 0
)

(instance rm1v401 of ShiversRoom
	(properties
		picture 1401
	)

	(method (init)
		(proc951_9 10112)
		(gSounds play: 10112 -1 0 0)
		(gSounds fade: 10112 98 1 40 0 0)
		(gSounds fade: 10111 0 1 40 1 0)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1403
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1402
	)

	(method (init)
		(self createPoly: 143 1 262 1 262 143 143 143)
		(super init: &rest)
	)
)

