;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13358)
(include sci.sh)
(use Main)

(public
	rm13v358 0
)

(instance rm13v358 of ShiversRoom
	(properties
		picture 13630
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13359
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 207
		nextRoom 13357
	)
)

