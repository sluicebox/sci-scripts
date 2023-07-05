;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27281)
(include sci.sh)
(use Main)

(public
	rm27v281 0
)

(instance rm27v281 of ShiversRoom
	(properties
		picture 27281
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
		nextRoom 27291
	)

	(method (init)
		(self createPoly: 73 142 108 60 126 60 165 142 74 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27280
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27282
	)
)

