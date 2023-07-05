;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23200)
(include sci.sh)
(use Main)

(public
	rm23v200 0
)

(instance rm23v200 of ShiversRoom
	(properties
		picture 23200
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23190
	)
)

