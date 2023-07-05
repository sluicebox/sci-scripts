;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32072)
(include sci.sh)
(use Main)

(public
	rm32v072 0
)

(instance rm32v072 of ShiversRoom
	(properties
		picture 32072
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitDown init: 5)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32071
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32071
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 32560
	)

	(method (init)
		(self createPoly: 0 123 263 123 263 143 0 143)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32350
	)

	(method (init)
		(self createPoly: 107 79 112 42 201 42 201 123 104 123)
		(super init: &rest)
	)
)

