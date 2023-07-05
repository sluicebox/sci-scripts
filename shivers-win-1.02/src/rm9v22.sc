;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9220)
(include sci.sh)
(use Main)

(public
	rm9v22 0
)

(instance rm9v22 of ShiversRoom
	(properties
		picture 9220
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitDoor init: 9)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9210
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9490
	)

	(method (init)
		(self createPoly: 38 141 32 46 24 6 52 16 125 53 180 102 201 142)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 9670
	)

	(method (init)
		(self createPoly: 210 95 210 44 274 44 272 116)
		(super init: &rest)
	)
)

