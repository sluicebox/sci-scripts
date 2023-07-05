;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11100)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v100 0
)

(instance rm11v100 of ShiversRoom
	(properties
		picture 11100
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(efExitDoor init: 9)
		(super init: &rest)
		(if (== gPrevRoomNum 12810) ; rm12v810
			(proc951_9 21902)
			(gSounds play: 21902 -1 8 0)
			(gSounds play: 11107 0 64 0)
			(if (proc951_11 9 11000)
				(proc951_9 21103)
				(gSounds play: 21103 -1 50 0)
			else
				(proc951_9 21101)
				(gSounds play: 21101 -1 48 0)
				(gSounds adjChainVol: 32)
				(gSounds playChain: -1 -5 21102 -1)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 8)
		(proc951_1 6)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 33
		nextRoom 11130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11110
	)

	(method (init)
		(self
			createPoly:
				264
				142
				225
				142
				225
				96
				255
				96
				255
				113
				263
				113
				263
				42
				228
				42
				228
				0
				265
				0
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11070
	)

	(method (init)
		(self
			createPoly:
				34
				142
				34
				127
				105
				127
				111
				117
				112
				77
				33
				77
				32
				32
				227
				32
				227
				75
				154
				75
				154
				115
				160
				127
				223
				128
				225
				142
		)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 11040
	)

	(method (init)
		(self createPoly: 228 95 228 42 264 42 263 113 255 113 255 96)
		(super init: &rest)
	)
)

