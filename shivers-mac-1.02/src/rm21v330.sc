;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21330)
(include sci.sh)
(use Main)

(public
	rm21v330 0
)

(instance rm21v330 of ShiversRoom
	(properties
		picture 21330
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
		nextRoom 21300
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21340
	)

	(method (init)
		(self createPoly: 64 140 94 3 179 3 221 141 65 141)
		(super init: &rest)
	)
)

