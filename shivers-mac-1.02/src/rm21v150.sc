;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21150)
(include sci.sh)
(use Main)

(public
	rm21v150 0
)

(instance rm21v150 of ShiversRoom
	(properties
		picture 21150
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21130
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21210
	)

	(method (init)
		(self createPoly: 45 120 71 145 190 144 190 0 45 0)
		(super init: &rest)
	)
)

