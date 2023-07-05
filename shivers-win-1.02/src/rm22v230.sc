;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22230)
(include sci.sh)
(use Main)

(public
	rm22v230 0
)

(instance rm22v230 of ShiversRoom
	(properties
		picture 22230
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitUp init: 4)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22270
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 22300
	)

	(method (init)
		(self createPoly: 28 0 28 35 230 35 230 0 28 0)
		(super init: &rest)
	)
)

