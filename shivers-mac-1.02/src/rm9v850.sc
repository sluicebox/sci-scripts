;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9850)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v850 0
)

(instance rm9v850 of ShiversRoom
	(properties
		picture 9850
	)

	(method (init)
		(if (IsFlag 43)
			(gSounds play: 10920 0 42 0)
			(ClearFlag 43)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efDoor init: 3)
		(efSecret init: 3)
		(efMasks init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(!= newRoomNumber 9390) ; rm9v39
				(!= newRoomNumber 9380) ; rm9v38
				(IsFlag 42)
				(proc951_11 0 9000)
			)
			(gSounds fade: 20908 0 10 16 1 0)
			(gSounds stop: 20903)
			(proc951_9 20903)
			(gSounds play: 20903 -1 0 0)
			(gSounds fade: 20903 42 10 16 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9380
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9390
	)
)

(instance efDoor of ExitFeature
	(properties
		nextRoom 9470
	)

	(method (init)
		(self createPoly: 55 75 54 13 83 3 82 78)
		(super init: &rest)
	)
)

(instance efSecret of ExitFeature
	(properties
		nextRoom 9420
	)

	(method (init)
		(self createPoly: 103 82 100 47 138 46 137 86)
		(super init: &rest)
	)
)

(instance efMasks of ExitFeature
	(properties
		nextRoom 9460
	)

	(method (init)
		(self createPoly: 39 33 21 33 21 76 52 74 50 31)
		(super init: &rest)
	)
)

