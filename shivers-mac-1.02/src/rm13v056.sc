;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13056)
(include sci.sh)
(use Main)

(public
	rm13v056 0
)

(instance rm13v056 of ShiversRoom
	(properties
		picture 13790
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13057
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13057
	)
)

