;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14270)
(include sci.sh)
(use Main)

(public
	rm14v270 0
)

(instance rm14v270 of ShiversRoom
	(properties
		picture 14270
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitStatue init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14120
	)

	(method (init)
		(self createPoly: 130 117 80 117 59 87 58 49 132 49)
		(super init: &rest)
	)
)

(instance efExitStatue of ExitFeature
	(properties
		nextRoom 14110
	)

	(method (init)
		(self createPoly: 131 117 132 49 243 49 243 90 236 110)
		(super init: &rest)
	)
)

