;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16750)
(include sci.sh)
(use Main)

(public
	rm16v750 0
)

(instance rm16v750 of ShiversRoom
	(properties
		picture 16750
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16340
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16360
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

