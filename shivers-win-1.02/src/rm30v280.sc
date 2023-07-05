;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30280)
(include sci.sh)
(use Main)

(public
	rm30v280 0
)

(instance rm30v280 of ShiversRoom
	(properties
		picture 30280
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeftHigh init: 2)
		(efExitLeftLow init: 2)
		(efExitPyramid init: 3)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeftHigh of ExitFeature
	(properties
		nextRoom 30290
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 62 0 36 0 0)
		(super init: &rest)
	)
)

(instance efExitLeftLow of ExitFeature
	(properties
		nextRoom 30290
	)

	(method (init)
		(self createPoly: 0 114 20 106 20 142 0 142 0 114)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30270
	)
)

(instance efExitPyramid of ExitFeature
	(properties
		nextRoom 30190
	)

	(method (init)
		(self createPoly: 0 38 47 98 0 113 1 38)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30180
	)

	(method (init)
		(self createPoly: 240 142 194 128 194 40 85 40 85 116 58 142 240 142)
		(super init: &rest)
	)
)

