;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8110)
(include sci.sh)
(use Main)

(public
	rm8v110 0
)

(instance rm8v110 of ShiversRoom
	(properties
		picture 8110
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8050
	)
)

