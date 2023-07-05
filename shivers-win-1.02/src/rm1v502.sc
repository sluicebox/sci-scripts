;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1502)
(include sci.sh)
(use Main)

(public
	rm1v502 0
)

(instance rm1v502 of ShiversRoom
	(properties
		picture 1502
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1500
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1503
	)

	(method (init)
		(self createPoly: 243 1 243 64 182 64 182 143 262 143 262 1)
		(super init: &rest)
	)
)

