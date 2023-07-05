;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1103)
(include sci.sh)
(use Main)

(public
	rm1v103 0
)

(instance rm1v103 of ShiversRoom
	(properties
		picture 1103
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitForward init: 3)
		(efExitDonut init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1101
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1096
	)

	(method (init)
		(self createPoly: 57 100 57 119 216 102 216 84 57 100)
		(super init: &rest)
	)
)

(instance efExitDonut of ExitFeature
	(properties
		nextRoom 1090
	)

	(method (init)
		(self createPoly: 216 98 264 98 264 46 239 51 227 58 218 69 216 98)
		(super init: &rest)
	)
)

