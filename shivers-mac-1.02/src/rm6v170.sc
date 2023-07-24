;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6170)
(include sci.sh)
(use Main)

(public
	rm6v170 0
)

(instance rm6v170 of ShiversRoom
	(properties
		picture 6170
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efDoor init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6120
	)

	(method (init)
		(self
			createPoly: 195 142 115 142 121 118 79 104 21 104 21 41 43 44 180 26 194 40
		)
		(super init: &rest)
	)
)

(instance efDoor of ExitFeature
	(properties
		nextRoom 6150
	)

	(method (init)
		(self createPoly: 215 28 215 142 195 142 195 40)
		(super init: &rest)
	)
)

