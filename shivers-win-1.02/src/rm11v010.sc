;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11010)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v010 0
)

(instance rm11v010 of ShiversRoom
	(properties
		picture 11010
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(efPlaque init: 0)
		(super init: &rest)
		(if (< gPrevRoomNum 11000)
			(proc951_7 21902)
			(proc951_9 21902)
			(gSounds play: 21902 -1 8 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11010
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11020
	)

	(method (init)
		(self
			createPoly:
				79
				136
				75
				125
				46
				100
				46
				40
				220
				40
				220
				115
				213
				123
				208
				134
		)
		(super init: &rest)
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 11420
	)

	(method (init)
		(self
			createPoly:
				243
				81
				222
				81
				223
				95
				231
				114
				217
				121
				215
				124
				244
				129
				256
				125
				242
				118
				241
				95
				251
				94
		)
		(super init: &rest)
	)
)

