;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10540)
(include sci.sh)
(use Main)
(use System)

(public
	rm10v540 0
)

(instance rm10v540 of ShiversRoom
	(properties
		picture 10540
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 8270) ; rm8v270
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 20801 0 6 30 1 0)
				(gSounds interruptChain:)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(gSounds adjChainVol: 98)
				(gSounds playChain: 21001 0 21002 -1)
				(gSounds fade: 20801 0 6 30 1 0)
				(self dispose:)
			)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10520
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10120
	)
)

