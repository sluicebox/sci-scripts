;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4440)
(include sci.sh)
(use Main)

(public
	rm4v440 0
)

(instance rm4v440 of ShiversRoom
	(properties
		picture 4310
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 220
		nextRoom 4450
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4470
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4420
	)

	(method (init)
		(self createPoly: 84 116 107 91 107 52 155 52 156 90 180 113)
		(super init: &rest)
	)
)

