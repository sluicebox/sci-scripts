;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30100)
(include sci.sh)
(use Main)

(public
	rm30v100 0
)

(instance rm30v100 of ShiversRoom
	(properties
		picture 30100
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30040
	)

	(method (init)
		(self createPoly: 59 143 87 123 87 44 180 44 180 123 197 143 59 143)
		(super init: &rest)
	)
)

