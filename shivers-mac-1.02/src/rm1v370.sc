;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1370)
(include sci.sh)
(use Main)

(public
	rm1v370 0
)

(instance rm1v370 of ShiversRoom
	(properties
		picture 1370
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
		(self createPoly: 40 1 40 143 1 143 1 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1371
	)

	(method (init)
		(self createPoly: 242 1 262 1 262 143 242 143)
		(super init: &rest)
	)
)

