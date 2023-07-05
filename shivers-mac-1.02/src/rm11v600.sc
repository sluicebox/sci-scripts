;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11600)
(include sci.sh)
(use Main)

(public
	rm11v600 0
)

(instance rm11v600 of ShiversRoom
	(properties
		picture 11600
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11190
	)

	(method (init)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11200
	)

	(method (init)
		(super init: &rest)
	)
)

