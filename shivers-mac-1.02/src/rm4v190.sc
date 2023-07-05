;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4190)
(include sci.sh)
(use Main)

(public
	rm4v190 0
)

(instance rm4v190 of ShiversRoom
	(properties
		picture 4100
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4180
	)

	(method (init)
		(self createPoly: 0 0 50 0 50 142 0 142 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4160
	)

	(method (init)
		(self createPoly: 180 0 262 0 262 142 180 142 180 0)
		(super init: &rest)
	)
)

