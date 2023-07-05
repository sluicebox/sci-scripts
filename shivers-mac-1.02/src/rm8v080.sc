;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8080)
(include sci.sh)
(use Main)

(public
	rm8v080 0
)

(instance rm8v080 of ShiversRoom
	(properties
		picture 8080
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitDownRight init: 5)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8060
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 118 8 123 10 123 11 142 0 142 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8110
	)

	(method (init)
		(self createPoly: 235 0 235 116 262 116 262 0 235 0)
		(super init: &rest)
	)
)

(instance efExitDownLeft of ExitFeature ; UNUSED
	(properties
		nextRoom 8090
	)

	(method (init)
		(self createPoly: 12 142 9 124 21 118 170 118 170 142)
		(super init: &rest)
	)
)

(instance efExitDownRight of ExitFeature
	(properties
		nextRoom 8100
	)

	(method (init)
		(self createPoly: 194 142 194 118 263 118 263 141)
		(super init: &rest)
	)
)

