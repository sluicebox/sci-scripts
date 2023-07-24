;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11240)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm11v240 0
)

(instance rm11v240 of ShiversRoom
	(properties
		picture 11240
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(cond
			((== gPrevRoomNum 19020) ; rm19v020
				(gCurRoom setScript: sEnter)
			)
			((IsFlag 43)
				(gSounds play: 11903 0 82 0)
			)
		)
		(ClearFlag 43)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11500
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 11230
	)

	(method (init)
		(self
			createPoly: 202 141 184 127 132 122 114 95 88 105 76 81 86 78 93 67 68 53 26 54 27 142
		)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fadeChain:)
				(gSounds fade: 21903 0 5 16 1 0)
				(gSounds play: 11903 0 82 self)
			)
			(1
				(gSounds interruptChain:)
				(= cycles 1)
			)
			(2
				(if (proc951_11 3 11000)
					(proc951_7 21103)
					(proc951_9 21103)
					(gSounds play: 21103 -1 50 0)
				else
					(proc951_7 21101)
					(proc951_9 21101)
					(gSounds adjChainVol: 32)
					(gSounds play: 21101 -1 48 0)
					(gSounds playChain: -1 -5 21102 -1)
				)
				(gGame handsOn:)
			)
		)
	)
)

