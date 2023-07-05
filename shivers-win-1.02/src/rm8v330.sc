;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8330)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v330 0
)

(instance rm8v330 of ShiversRoom
	(properties
		picture 8330
	)

	(method (init)
		(if (IsFlag 34)
			(= picture 8331)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8320
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8340
	)

	(method (init)
		(self createPoly: 234 0 263 0 263 144 204 144 234 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8260
	)

	(method (init)
		(self createPoly: 83 144 82 33 151 33 145 144 83 144)
		(super init: &rest)
	)
)

