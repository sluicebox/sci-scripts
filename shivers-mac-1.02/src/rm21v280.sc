;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21280)
(include sci.sh)
(use Main)
(use n951)

(public
	rm21v280 0
)

(instance rm21v280 of ShiversRoom
	(properties
		picture 21280
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 1)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21250
	)

	(method (init)
		(self createPoly: 18 140 49 79 49 4 2 4 2 142 17 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21250
	)

	(method (init)
		(self createPoly: 251 143 226 96 226 4 260 4 260 142 250 142)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21290
	)

	(method (init)
		(self createPoly: 90 2 90 65 55 140 212 140 176 71 176 2 91 2)
		(super init: &rest)
	)
)

