;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16360)
(include sci.sh)
(use Main)

(public
	rm16v360 0
)

(instance rm16v360 of ShiversRoom
	(properties
		picture 16360
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
		nextRoom 16750
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16350
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16650
	)

	(method (init)
		(self
			createPoly: 59 144 89 109 84 66 89 61 87 47 74 45 53 50 54 58 28 59 20 21 56 32 124 59 148 85 171 143
		)
		(super init: &rest)
	)
)

