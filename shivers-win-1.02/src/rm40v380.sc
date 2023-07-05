;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40380)
(include sci.sh)
(use Main)

(public
	rm40v380 0
)

(instance rm40v380 of ShiversRoom
	(properties
		picture 40160
	)

	(method (init)
		(efExitForward init: 3)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40360
	)

	(method (init)
		(self createPoly: 77 89 183 89 154 68 154 22 110 22 111 67 77 89)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 35100
	)

	(method (init)
		(self createPoly: 55 107 210 107 263 141 263 144 18 144 55 107)
		(super init: &rest)
	)
)

