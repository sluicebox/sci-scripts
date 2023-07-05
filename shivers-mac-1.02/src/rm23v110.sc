;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23110)
(include sci.sh)
(use Main)

(public
	rm23v110 0
)

(instance rm23v110 of ShiversRoom
	(properties
		picture 23110
	)

	(method (init)
		(gSounds fade: 32350 42 6 6 0 0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23100
	)
)

