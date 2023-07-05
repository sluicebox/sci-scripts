;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1500)
(include sci.sh)
(use Main)

(public
	rm1v500 0
)

(instance rm1v500 of ShiversRoom
	(properties
		picture 1500
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1503
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1502
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1480
	)

	(method (init)
		(self createPoly: 113 51 243 51 243 143 113 143 113 51)
		(super init: &rest)
	)
)

