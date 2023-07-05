;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1510)
(include sci.sh)
(use Main)

(public
	rm1v510 0
)

(instance rm1v510 of ShiversRoom
	(properties
		picture 1510
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1520
	)

	(method (init)
		(self createPoly: 0 112 6 84 56 68 57 53 181 56 262 81 263 142 0 142)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1511
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1511
	)
)

