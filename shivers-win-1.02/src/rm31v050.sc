;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31050)
(include sci.sh)
(use Main)
(use n951)

(public
	rm31v050 0
)

(instance rm31v050 of ShiversRoom
	(properties
		picture 31050
	)

	(method (init)
		(efExitForward init: 3)
		(efExitForwardLeft init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 7)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31430
	)

	(method (init)
		(self createPoly: 84 128 177 128 177 10 85 10 85 128)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 31080
	)

	(method (init)
		(self createPoly: 37 70 37 134 53 140 79 133 79 67 38 67 37 70)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31060
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31040
	)
)

