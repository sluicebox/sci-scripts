;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13233)
(include sci.sh)
(use Main)

(public
	rm13v233 0
)

(instance rm13v233 of ShiversRoom
	(properties
		picture 13500
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13231
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13232
	)
)

