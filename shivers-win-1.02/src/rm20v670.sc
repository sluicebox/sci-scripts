;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20670)
(include sci.sh)
(use Main)

(public
	rm20v670 0
)

(instance rm20v670 of ShiversRoom
	(properties
		picture 20670
	)

	(method (init)
		(efExitPlaque init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 20910
	)

	(method (init)
		(self createPoly: 125 85 98 81 112 65 138 68)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20680
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20660
	)
)

