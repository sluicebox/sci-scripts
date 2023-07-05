;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1102)
(include sci.sh)
(use Main)

(public
	rm1v102 0
)

(instance rm1v102 of ShiversRoom
	(properties
		picture 1102
	)

	(method (init)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1101
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1083
	)

	(method (init)
		(self createPoly: 233 110 38 90 45 49 27 48 4 51 10 67 10 95 220 118)
		(super init: &rest)
	)
)

