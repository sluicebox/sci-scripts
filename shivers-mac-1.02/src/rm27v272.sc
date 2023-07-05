;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27272)
(include sci.sh)
(use Main)

(public
	rm27v272 0
)

(instance rm27v272 of ShiversRoom
	(properties
		picture 27272
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
		nextRoom 27282
	)

	(method (init)
		(self createPoly: 104 32 88 142 174 142 169 32 104 32)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27271
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27273
	)
)

