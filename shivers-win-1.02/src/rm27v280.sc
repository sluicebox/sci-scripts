;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27280)
(include sci.sh)
(use Main)

(public
	rm27v280 0
)

(instance rm27v280 of ShiversRoom
	(properties
		picture 27280
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27270
	)

	(method (init)
		(self createPoly: 90 142 106 34 168 34 176 142 90 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27283
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27281
	)
)

