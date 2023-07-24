;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6070)
(include sci.sh)
(use Main)
(use n951)

(public
	rm6v070 0
)

(instance rm6v070 of ShiversRoom
	(properties
		picture 6070
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efLeftDoor init: 3)
		(efRightDoor init: 1)
		(efExitForward init: 3)
		(if (proc951_11 2 6000)
			(proc951_7 20603)
			(proc951_9 20603)
			(gSounds play: 20603 -1 0 0)
			(gSounds fade: 20603 32 15 8 0 0)
			(gSounds fadeChain:)
			(gSounds fade: 20601 0 15 8 1 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber &rest)
		(if (proc951_11 2 6000)
			(gSounds interruptChain:)
			(gSounds stop: 20601)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6090
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 52 11 50 11 137 20 131 20 144 0 144)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 241
		nextRoom 6100
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6040
	)

	(method (init)
		(self
			createPoly: 79 123 77 113 81 113 78 72 159 72 153 112 157 112 162 114 157 123
		)
		(super init: &rest)
	)
)

(instance efLeftDoor of ExitFeature
	(properties
		nextRoom 6030
	)

	(method (init)
		(self createPoly: 11 50 28 54 26 127 11 137)
		(super init: &rest)
	)
)

(instance efRightDoor of ExitFeature
	(properties
		nextRoom 6260
	)

	(method (init)
		(self
			createPoly: 221 132 221 55 241 50 241 112 235 113 235 130 226 129 223 133
		)
		(super init: &rest)
	)
)

