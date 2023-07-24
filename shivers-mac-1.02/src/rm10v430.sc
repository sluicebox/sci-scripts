;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10430)
(include sci.sh)
(use Main)

(public
	rm10v430 0
)

(instance rm10v430 of ShiversRoom
	(properties
		picture 10430
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10480
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10480
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10440
	)

	(method (init)
		(self
			createPoly: 81 144 93 121 69 100 69 70 69 50 120 25 166 27 206 50 200 99 174 118 189 142
		)
		(super init: &rest)
	)
)

