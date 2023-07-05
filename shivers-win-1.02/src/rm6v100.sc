;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6100)
(include sci.sh)
(use Main)
(use n951)

(public
	rm6v100 0
)

(instance rm6v100 of ShiversRoom
	(properties
		picture 6100
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efDoor init: 3)
		(efJacket init: 3)
		(if (and (!= gPrevRoomNum 6090) (proc951_11 2 6000)) ; rm6v090
			(gSounds fade: 20603 0 15 8 1 0)
			(gSounds playChain: -1 -4 20602 -1)
			(gSounds adjChainVol: 34)
			(proc951_7 20601)
			(proc951_9 20601)
			(gSounds play: 20601 -1 0 0)
			(gSounds fade: 20601 10 15 5 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6090
	)

	(method (init)
		(self
			createPoly:
				192
				143
				191
				125
				198
				123
				203
				109
				243
				112
				243
				0
				263
				0
				263
				143
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6140
	)

	(method (init)
		(self
			createPoly:
				107
				135
				106
				51
				133
				52
				167
				56
				178
				56
				178
				104
				175
				104
				171
				111
				161
				109
				139
				111
				139
				117
				149
				119
				149
				138
		)
		(super init: &rest)
	)
)

(instance efDoor of ExitFeature
	(properties
		nextRoom 6150
	)

	(method (init)
		(self createPoly: 70 142 70 46 106 50 107 135)
		(super init: &rest)
	)
)

(instance efJacket of ExitFeature
	(properties
		nextRoom 6111
	)

	(method (init)
		(self createPoly: 48 115 38 129 38 145 70 144 61 128 51 114)
		(super init: &rest)
	)
)

