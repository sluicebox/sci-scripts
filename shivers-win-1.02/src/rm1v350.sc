;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1350)
(include sci.sh)
(use Main)

(public
	rm1v350 0
)

(instance rm1v350 of ShiversRoom
	(properties
		picture 1350
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1360
	)

	(method (init)
		(self createPoly: 19 142 47 110 47 51 227 51 226 106 263 141)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1361
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1361
	)
)

