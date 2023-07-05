;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32100)
(include sci.sh)
(use Main)

(public
	rm32v100 0
)

(instance rm32v100 of ShiversRoom
	(properties
		picture 32100
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32110
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32120
	)

	(method (init)
		(self createPoly: 85 135 191 135 178 110 178 49 98 49 98 109 85 134)
		(super init: &rest)
	)
)

