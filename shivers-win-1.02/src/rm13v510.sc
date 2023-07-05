;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13510)
(include sci.sh)
(use Main)

(public
	rm13v510 0
)

(instance rm13v510 of ShiversRoom
	(properties
		picture 13690
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitForwardLeft init: 9)
		(efExitForwardRight init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13511
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13511
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 13500
	)

	(method (init)
		(self createPoly: 73 142 73 0 97 22 97 120)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13496
	)

	(method (init)
		(self createPoly: 98 120 98 23 188 23 188 121 227 143 73 143)
		(super init: &rest)
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 13492
	)

	(method (init)
		(self createPoly: 227 142 189 121 189 22 227 0)
		(super init: &rest)
	)
)

