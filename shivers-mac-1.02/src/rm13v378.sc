;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13378)
(include sci.sh)
(use Main)

(public
	rm13v378 0
)

(instance rm13v378 of ShiversRoom
	(properties
		picture 13570
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13379
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13380
	)
)

