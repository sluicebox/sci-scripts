;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22210)
(include sci.sh)
(use Main)

(public
	rm22v210 0
)

(instance rm22v210 of ShiversRoom
	(properties
		picture 22210
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitUp init: 4)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22230
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22250
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 22300
	)

	(method (init)
		(self createPoly: 20 0 20 55 243 55 243 0)
		(super init: &rest)
	)
)

