;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15020)
(include sci.sh)
(use Main)

(public
	rm15v2 0
)

(instance rm15v2 of ShiversRoom
	(properties
		picture 15020
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15010
	)
)

