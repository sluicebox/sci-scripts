;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27250)
(include sci.sh)
(use Main)

(public
	rm27v250 0
)

(instance rm27v250 of ShiversRoom
	(properties
		picture 27250
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27252
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 50
		nextRoom 27251
	)
)

