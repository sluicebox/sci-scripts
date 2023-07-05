;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18100)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm18v10 0
)

(instance rm18v10 of ShiversRoom
	(properties
		picture 18100
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(if (IsFlag 43)
			(gSounds play: 11802 0 82 0)
		)
		(ClearFlag 43)
		(super init: &rest)
		(if (== gPrevRoomNum 40005) ; rm40v005
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
		nextRoom 18070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18120
	)

	(method (init)
		(self createPoly: 83 144 103 90 103 64 150 64 150 91 248 142)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 24001 0 1 30 1 self)
			)
			(1
				(proc951_10 24001)
				(= cycles 1)
			)
			(2
				(proc951_9 21602)
				(gSounds play: 21602 -1 0 0)
				(gSounds fade: 21602 51 1 30 0 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

