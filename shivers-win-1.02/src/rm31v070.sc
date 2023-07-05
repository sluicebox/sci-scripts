;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31070)
(include sci.sh)
(use Main)
(use n951)

(public
	rm31v070 0
)

(instance rm31v070 of ShiversRoom
	(properties
		picture 31070
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 7)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31030
	)

	(method (init)
		(self createPoly: 54 12 54 123 233 123 233 13 55 12)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31430
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31430
	)
)

