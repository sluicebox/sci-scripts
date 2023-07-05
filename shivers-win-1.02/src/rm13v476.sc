;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13476)
(include sci.sh)
(use Main)

(public
	rm13v476 0
)

(instance rm13v476 of ShiversRoom
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
		nextRoom 13474
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 229
		nextRoom 13475
	)
)

