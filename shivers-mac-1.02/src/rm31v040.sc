;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31040)
(include sci.sh)
(use Main)

(public
	rm31v040 0
)

(instance rm31v040 of ShiversRoom
	(properties
		picture 31040
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31010
	)

	(method (init)
		(self createPoly: 108 108 152 108 152 46 107 46 107 108)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31050
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31030
	)
)

