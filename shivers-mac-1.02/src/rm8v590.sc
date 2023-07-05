;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8590)
(include sci.sh)
(use Main)

(public
	rm8v590 0
)

(instance rm8v590 of ShiversRoom
	(properties
		picture 8590
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitDownLeft init: 5)
		(efExitDownRight init: 5)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8580
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8610
	)

	(method (init)
		(self createPoly: 235 0 262 0 262 118 235 118 235 0)
		(super init: &rest)
	)
)

(instance efExitDownLeft of ExitFeature
	(properties
		nextRoom 8600
	)

	(method (init)
		(self createPoly: 65 141 63 120 159 120 159 142)
		(super init: &rest)
	)
)

(instance efExitDownRight of ExitFeature
	(properties
		nextRoom 8620
	)

	(method (init)
		(self createPoly: 182 141 182 120 262 120 262 142)
		(super init: &rest)
	)
)

