;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23230)
(include sci.sh)
(use Main)

(public
	rm23v230 0
)

(instance rm23v230 of ShiversRoom
	(properties
		picture 23230
	)

	(method (init)
		(gSounds fade: 32350 0 6 6 0 0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 210
		nextRoom 23220
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 23930
	)

	(method (init)
		(self createPoly: 165 87 140 87 142 98 167 98 165 87)
		(super init: &rest)
	)
)

