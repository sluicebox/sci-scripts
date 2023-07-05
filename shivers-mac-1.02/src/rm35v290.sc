;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35290)
(include sci.sh)
(use Main)

(public
	rm35v290 0
)

(instance rm35v290 of ShiversRoom
	(properties
		picture 35290
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35190
	)

	(method (init)
		(self createPoly: 61 104 171 128 208 113 208 21 195 0 75 0 63 27 61 104)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35110
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35320
	)
)

