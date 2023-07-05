;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33180)
(include sci.sh)
(use Main)

(public
	rm33v180 0
)

(instance rm33v180 of ShiversRoom
	(properties
		picture 33180
	)

	(method (init)
		(efExitForward init: 3)
		(efExitForwardLeft init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33190
	)

	(method (init)
		(self createPoly: 86 14 86 141 208 141 208 14 87 14)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 33140
	)

	(method (init)
		(self createPoly: 16 1 16 143 51 143 51 0 16 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33170
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33110
	)
)

