;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1311)
(include sci.sh)
(use Main)

(public
	rm1v311 0
)

(instance rm1v311 of ShiversRoom
	(properties
		picture 1311
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1320
	)

	(method (init)
		(self createPoly: 8 0 29 143 0 143 0 0 8 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1320
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1301
	)

	(method (init)
		(self
			createPoly: 263 134 168 105 101 94 95 0 8 0 42 143 263 144 263 135
		)
		(super init: &rest)
	)
)

