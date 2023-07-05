;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30160)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v160 0
)

(instance rm30v160 of ShiversRoom
	(properties
		picture 30160
	)

	(method (init)
		(if (IsFlag 85)
			(self picture: 30161)
		)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRightHigh init: 1)
		(efExitRightLow init: 1)
		(efExitPyramid init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30130
	)
)

(instance efExitRightHigh of ExitFeature
	(properties
		nextRoom 30150
	)

	(method (init)
		(self createPoly: 240 0 240 72 262 45 262 0 240 0)
		(super init: &rest)
	)
)

(instance efExitRightLow of ExitFeature
	(properties
		nextRoom 30150
	)

	(method (init)
		(self createPoly: 243 109 263 114 263 142 243 142 243 109)
		(super init: &rest)
	)
)

(instance efExitPyramid of ExitFeature
	(properties
		nextRoom 30190
	)

	(method (init)
		(self createPoly: 264 44 263 114 218 101 264 44)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30200
	)

	(method (init)
		(self createPoly: 186 129 186 52 89 52 89 127 186 127)
		(super init: &rest)
	)
)

