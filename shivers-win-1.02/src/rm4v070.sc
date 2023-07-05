;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4070)
(include sci.sh)
(use Main)

(public
	rm4v070 0
)

(instance rm4v070 of ShiversRoom
	(properties
		picture 4100
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4060
	)

	(method (init)
		(self createPoly: 0 0 50 0 50 142 0 142 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4040
	)

	(method (init)
		(self createPoly: 210 0 262 0 262 142 210 142 210 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 4070
	)

	(method (init)
		(self createPoly: 201 134 57 134 83 107 83 20 166 20 166 100)
		(super init: &rest)
	)
)

