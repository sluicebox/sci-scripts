;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4430)
(include sci.sh)
(use Main)

(public
	rm4v430 0
)

(instance rm4v430 of ShiversRoom
	(properties
		picture 4010
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4420
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4420
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4460
	)

	(method (init)
		(self createPoly: 64 131 86 111 86 40 176 40 176 110 196 130)
		(super init: &rest)
	)
)

