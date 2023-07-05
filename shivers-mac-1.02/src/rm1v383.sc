;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1383)
(include sci.sh)
(use Main)

(public
	rm1v383 0
)

(instance rm1v383 of ShiversRoom
	(properties
		picture 1443
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1380
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1382
	)

	(method (init)
		(self createPoly: 243 1 262 1 262 143 243 143)
		(super init: &rest)
	)
)

