;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27161)
(include sci.sh)
(use Main)

(public
	rm27v161 0
)

(instance rm27v161 of ShiversRoom
	(properties
		picture 27161
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27160
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 50
		nextRoom 27162
	)
)

