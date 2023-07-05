;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11230)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v230 0
)

(instance rm11v230 of ShiversRoom
	(properties
		picture 11230
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 2)
		(efExitMiddle init: 3)
		(efExitDoor init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 8)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11220
	)

	(method (init)
		(self createPoly: 32 33 37 143 0 143 0 0 32 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11220
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11190
	)

	(method (init)
		(self createPoly: 35 32 104 27 104 142 34 142 35 32)
		(super init: &rest)
	)
)

(instance efExitMiddle of ExitFeature
	(properties
		nextRoom 11600
	)

	(method (init)
		(self createPoly: 157 25 225 18 227 142 157 142 157 26)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 11160
	)

	(method (init)
		(self createPoly: 105 28 154 24 154 142 103 142 104 29)
		(super init: &rest)
	)
)

