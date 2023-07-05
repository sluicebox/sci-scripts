;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23430)
(include sci.sh)
(use Main)

(public
	rm23v430 0
)

(instance rm23v430 of ShiversRoom
	(properties
		picture 23430
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPlaque init: 3)
		(efExitSkullDial init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23620
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23390
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 23940
	)

	(method (init)
		(self createPoly: 13 92 13 112 24 112 24 143 54 143 54 91 13 91)
		(super init: &rest)
	)
)

(instance efExitSkullDial of ExitFeature
	(properties
		nextRoom 23650
	)

	(method (init)
		(self createPoly: 204 64 204 105 255 105 255 64 204 64)
		(super init: &rest)
	)
)

