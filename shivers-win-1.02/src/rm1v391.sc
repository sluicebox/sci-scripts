;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1391)
(include sci.sh)
(use Main)

(public
	rm1v391 0
)

(instance rm1v391 of ShiversRoom
	(properties
		picture 1391
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1392
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1390
	)

	(method (init)
		(self createPoly: 143 1 262 1 262 143 143 143)
		(super init: &rest)
	)
)

