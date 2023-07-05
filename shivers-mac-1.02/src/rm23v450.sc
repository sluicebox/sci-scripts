;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23450)
(include sci.sh)
(use Main)

(public
	rm23v450 0
)

(instance rm23v450 of ShiversRoom
	(properties
		picture 23450
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitDoor init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23480
	)

	(method (init)
		(self createPoly: 0 0 0 32 30 32 30 123 0 123 0 142 63 142 63 0 1 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23460
	)

	(method (init)
		(self createPoly: 262 0 207 0 207 143 262 143 262 1)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 23400
	)

	(method (init)
		(self createPoly: 1 30 29 30 26 118 0 118 0 30)
		(super init: &rest)
	)
)

