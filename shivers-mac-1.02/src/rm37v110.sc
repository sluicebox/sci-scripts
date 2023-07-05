;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37110)
(include sci.sh)
(use Main)

(public
	rm37v110 0
)

(instance rm37v110 of ShiversRoom
	(properties
		picture 37110
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efExitDoor init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37111
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 38 0 32 0 135 20 125 20 143 0 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 37080
	)

	(method (init)
		(self
			createPoly: 172 115 160 122 85 124 88 70 114 70 117 49 143 40 172 35
		)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 37030
	)

	(method (init)
		(self createPoly: 0 32 20 38 22 124 0 135)
		(super init: &rest)
	)
)

