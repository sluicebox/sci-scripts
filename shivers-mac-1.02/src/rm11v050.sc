;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11050)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v050 0
)

(instance rm11v050 of ShiversRoom
	(properties
		picture 11050
	)

	(method (init)
		(super init: &rest)
		(if (and (== gPrevRoomNum 11040) (IsFlag 43)) ; rm11v040
			(ClearFlag 43)
			(gSounds play: 11105 0 32 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(cond
			((proc951_11 9 11000)
				(proc951_7 21103)
				(proc951_9 21103)
				(gSounds play: 21103 -1 50 0)
				(gSounds fade: 21101 0 15 8 1 0)
				(gSounds fadeChain:)
			)
			((proc951_11 3 11000)
				(gSounds fade: 21103 0 5 16 1 0)
				(proc951_7 21101)
				(proc951_9 21101)
				(gSounds play: 21101 -1 48 0)
				(gSounds playChain: -1 -5 21102 -1)
				(gSounds adjChainVol: 32)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (<= 11000 newRoomNumber 11040) ; rm11v040
			(if (proc951_11 3 11000)
				(gSounds stop: 21101)
				(gSounds stopChain:)
			)
			(gSounds fade: 21103 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11060
	)

	(method (init)
		(self
			createPoly:
				203
				135
				177
				115
				178
				98
				185
				98
				185
				28
				120
				27
				120
				104
				120
				79
				107
				79
				106
				85
				100
				107
				62
				111
				52
				125
				62
				135
		)
		(super init: &rest)
	)
)

