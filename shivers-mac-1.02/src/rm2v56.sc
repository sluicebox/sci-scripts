;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2560)
(include sci.sh)
(use Main)

(public
	rm2v56 0
)

(instance rm2v56 of ShiversRoom
	(properties
		picture 2560
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2270
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2260
	)

	(method (init)
		(self createPoly: 200 0 262 0 262 144 200 144 200 0)
		(super init: &rest)
	)
)

