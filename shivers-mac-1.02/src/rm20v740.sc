;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20740)
(include sci.sh)
(use Main)

(public
	rm20v740 0
)

(instance rm20v740 of ShiversRoom
	(properties
		picture 20740
	)

	(method (init)
		(efExitUp init: 4)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 20290
	)

	(method (init)
		(self createPoly: 34 0 34 38 224 38 224 0 35 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20750
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20730
	)
)

