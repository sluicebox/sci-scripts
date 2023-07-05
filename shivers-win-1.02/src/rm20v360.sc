;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20360)
(include sci.sh)
(use Main)
(use n951)

(public
	rm20v360 0
)

(instance rm20v360 of ShiversRoom
	(properties
		picture 20360
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(efExitDoor init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 6)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20850
	)

	(method (init)
		(self createPoly: 60 30 200 30 200 110 60 110)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20350
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20350
	)

	(method (init)
		(self
			createPoly:
				0
				0
				0
				20
				9
				33
				18
				50
				23
				72
				29
				95
				28
				113
				28
				119
				1
				119
				1
				141
				54
				141
				54
				0
				0
				0
		)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 20410
	)

	(method (init)
		(self createPoly: 0 23 7 35 14 48 27 94 27 113 2 113 0 113 0 23)
		(super init: &rest)
	)
)

