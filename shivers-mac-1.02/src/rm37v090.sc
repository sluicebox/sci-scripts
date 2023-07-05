;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37090)
(include sci.sh)
(use Main)

(public
	rm37v090 0
)

(instance rm37v090 of ShiversRoom
	(properties
		picture 37090
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37100
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37150
	)

	(method (init)
		(self createPoly: 102 112 102 48 130 36 156 47 156 113)
		(super init: &rest)
	)
)

