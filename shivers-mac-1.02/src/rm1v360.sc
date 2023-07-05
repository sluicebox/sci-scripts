;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1360)
(include sci.sh)
(use Main)

(public
	rm1v360 0
)

(instance rm1v360 of ShiversRoom
	(properties
		picture 1360
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1373
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 143 0 143 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1371
	)

	(method (init)
		(self createPoly: 222 0 262 0 262 143 222 143 222 0)
		(super init: &rest)
	)
)

