;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20300)
(include sci.sh)
(use Main)

(public
	rm20v300 0
)

(instance rm20v300 of ShiversRoom
	(properties
		picture 20300
	)

	(method (init)
		(efExitDown init: 5)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 20750
	)

	(method (init)
		(self createPoly: 31 103 31 142 227 142 227 104 31 104)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20270
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20290
	)
)

