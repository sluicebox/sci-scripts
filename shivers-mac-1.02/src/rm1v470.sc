;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1470)
(include sci.sh)
(use Main)

(public
	rm1v470 0
)

(instance rm1v470 of ShiversRoom
	(properties
		picture 1470
	)

	(method (init)
		(efExitForwardLeft init: 2)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1480
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1480
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 1490
	)

	(method (init)
		(self createPoly: 39 127 39 39 99 37 183 37 183 126)
		(super init: &rest)
	)
)

