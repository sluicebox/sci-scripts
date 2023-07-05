;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14280)
(include sci.sh)
(use Main)

(public
	rm14v280 0
)

(instance rm14v280 of ShiversRoom
	(properties
		picture 14280
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 14180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14160
	)

	(method (init)
		(self createPoly: 108 117 105 87 87 82 85 25 125 21 159 22 152 104)
		(super init: &rest)
	)
)

