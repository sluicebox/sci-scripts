;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8000)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm8v000 0
)

(instance rm8v000 of ShiversRoom
	(properties)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (IsFlag 34)
			(= picture 8000)
		else
			(= picture 8010)
		)
		(if (IsFlag 43)
			(gSounds play: 10810 0 40 0)
			(ClearFlag 43)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 9470) ; rm9v47
			(gCurRoom setScript: sEnter)
		)
	)

	(method (newRoom)
		(proc951_1 6)
		(proc951_1 0)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8020
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 20903 0 1 30 1 self)
			)
			(1
				(proc951_10 20903)
				(= cycles 1)
			)
			(2
				(proc951_9 20801)
				(gSounds play: 20801 -1 0 0)
				(gSounds fade: 20801 66 1 30 0 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

