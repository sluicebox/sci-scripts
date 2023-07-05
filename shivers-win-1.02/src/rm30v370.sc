;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30370)
(include sci.sh)
(use Main)

(public
	rm30v370 0
)

(instance rm30v370 of ShiversRoom
	(properties
		picture 30370
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30380
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30400
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30430
	)

	(method (init)
		(self createPoly: 204 50 246 45 246 116 204 121 204 50)
		(super init: &rest)
	)
)

