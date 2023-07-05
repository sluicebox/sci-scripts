;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27024)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm27v024 0
)

(instance rm27v024 of ShiversRoom
	(properties
		picture 27023
	)

	(method (init)
		(efExitUp init: 4)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
		(if (== gPrevRoomNum 20150) ; rm20v150
			(ClearFlag 43)
			(gSounds play: 12015 0 82 0)
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 27021
	)

	(method (init)
		(self createPoly: 33 0 33 40 225 40 225 0 34 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27020
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27022
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 22001 0 1 30 1 self)
			)
			(1
				(proc951_10 22001)
				(= cycles 1)
			)
			(2
				(proc951_9 22701)
				(gSounds play: 22701 -1 0 0)
				(gSounds fade: 22701 98 1 30 0 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

