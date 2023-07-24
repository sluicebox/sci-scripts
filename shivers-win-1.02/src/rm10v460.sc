;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10460)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm10v460 0
)

(instance rm10v460 of ShiversRoom
	(properties
		picture 10460
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
		(if (== gPrevRoomNum 18240) ; rm18v24
			(gCurRoom setScript: sEnter)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 9)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10450
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10450
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10470
	)

	(method (init)
		(self
			createPoly: 80 137 107 100 97 93 91 80 91 65 97 52 114 41 146 41 167 52 174 76 168 93 157 100 179 135
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
				(gSounds fade: 21602 0 1 30 1 self)
				(if (IsFlag 43)
					(gSounds play: 11806 0 82 0)
					(ClearFlag 43)
				)
			)
			(1
				(proc951_10 21602)
				(gSounds adjChainVol: 98)
				(gSounds playChain: 21001 0 21002 -1)
				(gGame handsOn:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

