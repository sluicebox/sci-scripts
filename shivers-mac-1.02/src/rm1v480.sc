;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1480)
(include sci.sh)
(use Main)

(public
	rm1v480 0
)

(instance rm1v480 of ShiversRoom
	(properties
		picture 1480
	)

	(method (init)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1490
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1461
	)

	(method (init)
		(self createPoly: 15 143 125 77 125 33 206 32 204 79 263 140)
		(super init: &rest)
	)
)

