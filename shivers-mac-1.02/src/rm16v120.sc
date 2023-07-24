;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16120)
(include sci.sh)
(use Main)

(public
	rm16v120 0
)

(instance rm16v120 of ShiversRoom
	(properties
		picture 16120
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(efExitDoor init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16110
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16030
	)

	(method (init)
		(self
			createPoly: 213 142 173 130 165 100 173 28 96 28 96 104 54 142 54 143 213 143 212 142
		)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 16020
	)

	(method (init)
		(self createPoly: 22 36 57 50 57 134 41 143 20 143 20 36 21 36)
		(super init: &rest)
	)
)

