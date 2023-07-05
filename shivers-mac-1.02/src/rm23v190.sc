;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23190)
(include sci.sh)
(use Main)

(public
	rm23v190 0
)

(instance rm23v190 of ShiversRoom
	(properties
		picture 23190
	)

	(method (init)
		(gSounds fade: 32350 18 6 6 0 0)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23230
	)

	(method (init)
		(self createPoly: 90 36 168 33 169 112 185 133 68 133 90 114 90 36)
		(super init: &rest)
	)
)

