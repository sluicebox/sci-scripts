;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31350)
(include sci.sh)
(use Main)

(public
	rm31v350 0
)

(instance rm31v350 of ShiversRoom
	(properties
		picture 31350
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31360
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31340
	)
)

