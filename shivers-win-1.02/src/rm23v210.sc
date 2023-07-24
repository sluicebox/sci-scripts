;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23210)
(include sci.sh)
(use Main)

(public
	rm23v210 0
)

(instance rm23v210 of ShiversRoom
	(properties
		picture 23210
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
		nextRoom 23180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23120
	)

	(method (init)
		(self
			createPoly: 172 141 189 29 115 53 91 55 77 28 64 28 29 96 37 106 172 141
		)
		(super init: &rest)
	)
)

