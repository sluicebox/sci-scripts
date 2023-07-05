;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16340)
(include sci.sh)
(use Main)

(public
	rm16v340 0
)

(instance rm16v340 of ShiversRoom
	(properties
		picture 16340
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 2)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16360
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16750
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16350
	)

	(method (init)
		(self createPoly: 43 142 33 32 35 6 41 1 70 1 78 28 84 125)
		(super init: &rest)
	)
)

