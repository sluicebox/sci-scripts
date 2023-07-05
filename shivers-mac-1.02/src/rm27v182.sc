;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27182)
(include sci.sh)
(use Main)

(public
	rm27v182 0
)

(instance rm27v182 of ShiversRoom
	(properties
		picture 27182
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27181
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 50
		nextRoom 27183
	)
)

