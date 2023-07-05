;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6140)
(include sci.sh)
(use Main)

(public
	rm6v140 0
)

(instance rm6v140 of ShiversRoom
	(properties
		picture 6140
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efMap init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 22
		nextRoom 6150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6130
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6190
	)

	(method (init)
		(self createPoly: 77 143 79 17 184 19 178 140 179 143)
		(super init: &rest)
	)
)

(instance efMap of ExitFeature
	(properties
		nextRoom 6200
	)

	(method (init)
		(self createPoly: 49 98 51 33 74 42 74 90)
		(super init: &rest)
	)
)

