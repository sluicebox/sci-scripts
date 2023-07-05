;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13496)
(include sci.sh)
(use Main)

(public
	rm13v496 0
)

(instance rm13v496 of ShiversRoom
	(properties
		picture 13470
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 45
		nextRoom 13499
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 229
		nextRoom 13498
	)
)

