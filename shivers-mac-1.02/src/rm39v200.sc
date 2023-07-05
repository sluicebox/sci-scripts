;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39200)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm39v200 0
)

(instance rm39v200 of ShiversRoom
	(properties
		picture 39200
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 39250) ; rm39v250
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39090
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (proc951_11 7 39000)
					(gSounds fade: 23905 0 5 16 1 0)
				else
					(gSounds fade: 23903 0 5 16 1 0)
				)
				(gSounds play: 13909 0 82 self)
				(ClearFlag 43)
			)
			(1
				(if (not (proc951_11 7 39000))
					(gSounds play: 23901 -1 0 0)
					(gSounds play: 23902 -1 0 0)
					(gSounds fade: 23901 26 5 16 0 0)
					(gSounds fade: 23902 66 5 16 0 0)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

