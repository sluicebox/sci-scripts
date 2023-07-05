;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38100)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm38v100 0
)

(instance rm38v100 of ShiversRoom
	(properties
		picture 38100
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 2)
		(efExitForward init: 3)
		(super init: &rest)
		(if (== gPrevRoomNum 38011) ; rm38v011
			(if (IsFlag 6)
				(gSounds play: 10407 0 90 0)
			else
				(gSounds play: 10503 0 90 0)
			)
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 38130
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 38110
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 38120
	)

	(method (init)
		(self createPoly: 92 94 176 94 176 120 91 120 91 94)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc951_7 20601)
				(proc951_9 20601)
				(= cycles 1)
			)
			(1
				(= seconds 2)
			)
			(2
				(proc951_7 20602)
				(gSounds play: 20601 -1 0 0)
				(gSounds fade: 20601 10 15 5 0 0)
				(gSounds playChain: -1 -4 20602 -1)
				(gSounds adjChainVol: 34)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

