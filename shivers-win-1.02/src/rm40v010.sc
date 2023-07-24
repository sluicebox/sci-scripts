;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40010)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm40v010 0
)

(instance rm40v010 of ShiversRoom
	(properties
		picture 40010
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(if (IsFlag 43)
			(gSounds play: 11802 0 82 0)
		)
		(ClearFlag 43)
		(super init: &rest)
		(if (== gPrevRoomNum 18080) ; rm18v8
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40020
	)

	(method (init)
		(self
			createPoly: 84 143 107 125 121 105 121 1 189 1 189 85 231 95 242 106 242 142 85 143
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40005
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40005
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 21602 0 1 30 1 self)
			)
			(1
				(proc951_10 21602)
				(= cycles 1)
			)
			(2
				(proc951_9 24001)
				(gSounds play: 24001 -1 0 0)
				(gSounds fade: 24001 90 1 30 0 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

