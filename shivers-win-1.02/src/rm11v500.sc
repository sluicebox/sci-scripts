;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11500)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v500 0
)

(instance rm11v500 of ShiversRoom
	(properties
		picture 11500
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efPlaque init: 3)
		(super init: &rest)
		(if (== gPrevRoomNum 11240) ; rm11v240
			(proc951_7 21101)
			(proc951_9 21101)
			(gSounds play: 21101 -1 48 0)
			(gSounds adjChainVol: 32)
			(gSounds playChain: -1 -5 21102 -1)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11320
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 11400
	)

	(method (init)
		(self
			createPoly:
				210
				74
				183
				74
				184
				88
				196
				118
				182
				121
				170
				129
				173
				134
				186
				142
				221
				142
				228
				136
				210
				121
				208
				94
				223
				93
				218
				80
		)
		(super init: &rest)
	)
)

