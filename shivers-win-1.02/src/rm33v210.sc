;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33210)
(include sci.sh)
(use Main)

(public
	rm33v210 0
)

(instance rm33v210 of ShiversRoom
	(properties
		picture 33210
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33230
	)

	(method (init)
		(self createPoly: 42 5 42 141 186 141 186 5 42 5)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33080
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33080
	)
)

