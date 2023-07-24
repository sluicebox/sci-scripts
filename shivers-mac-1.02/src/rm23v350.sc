;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23350)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v350 0
)

(instance rm23v350 of ShiversRoom
	(properties
		picture 23350
	)

	(method (init)
		(efExitForward init: 3)
		(efExitForwardRight init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 5)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23360
	)
)

(instance efExitForwardRight of ExitFeature
	(properties
		nextRoom 23300
	)

	(method (init)
		(self createPoly: 251 145 251 38 228 46 228 125 250 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23360
	)

	(method (init)
		(self createPoly: 252 140 251 32 235 37 235 2 264 1 265 143 252 140)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23310
	)

	(method (init)
		(self
			createPoly: 182 133 166 115 154 110 143 28 106 29 94 75 66 84 63 127 78 132 78 135 182 136
		)
		(super init: &rest)
	)
)

