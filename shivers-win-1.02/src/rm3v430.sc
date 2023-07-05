;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3430)
(include sci.sh)
(use Main)

(public
	rm3v430 0
)

(instance rm3v430 of ShiversRoom
	(properties
		picture 3430
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3420
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3440
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 3310
	)

	(method (init)
		(self createPoly: 90 89 72 5 239 8 206 91)
		(super init: &rest)
	)
)

