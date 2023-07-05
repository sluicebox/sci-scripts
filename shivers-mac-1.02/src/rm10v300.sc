;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10300)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm10v300 0
)

(instance rm10v300 of ShiversRoom
	(properties
		picture 10300
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 39030) ; rm39v030
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10310
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10280
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (proc951_11 7 39000)
					(gSounds fade: 23904 0 1 30 1 self)
				else
					(gSounds fade: 23901 0 1 30 1 self)
					(gSounds fade: 23902 0 1 30 1 0)
				)
				(gSounds play: 13911 0 82 0)
			)
			(1
				(proc951_10 23901)
				(proc951_10 23903)
				(proc951_10 23904)
				(= cycles 1)
			)
			(2
				(gSounds adjChainVol: 98)
				(gSounds playChain: 21001 0 21002 -1)
				(ClearFlag 43)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

