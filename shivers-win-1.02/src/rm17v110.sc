;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17110)
(include sci.sh)
(use Main)
(use n951)

(public
	rm17v110 0
)

(instance rm17v110 of ShiversRoom
	(properties
		picture 17110
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitDoor init: 9)
		(efExitCannisters init: 9)
		(super init: &rest)
		(if (proc951_11 9 17000)
			(gSounds fadeChain:)
			(proc951_7 21703)
			(gSounds play: 21703 -1 50 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (proc951_11 9 17000)
			(gSounds interruptChain:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 17120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 17120
	)

	(method (init)
		(self
			createPoly:
				263
				143
				243
				143
				243
				107
				263
				107
				263
				40
				243
				40
				243
				0
				263
				0
		)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 17080
	)

	(method (init)
		(self createPoly: 64 143 64 13 101 13 101 143)
		(super init: &rest)
	)
)

(instance efExitCannisters of ExitFeature
	(properties
		nextRoom 17090
	)

	(method (init)
		(self
			createPoly:
				263
				107
				252
				108
				243
				107
				231
				101
				239
				82
				235
				74
				235
				60
				237
				58
				234
				50
				238
				40
				243
				40
				262
				40
		)
		(super init: &rest)
	)
)

