;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33320)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm33v320 0
)

(instance rm33v320 of ShiversRoom
	(properties
		picture 33320
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
		(if (== gPrevRoomNum 30190) ; rm30v190
			(ClearFlag 43)
			(gCurRoom setScript: sEnter)
		)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 7)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33060
	)

	(method (init)
		(self createPoly: 263 2 185 2 185 143 263 143 263 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33250
	)

	(method (init)
		(self createPoly: 0 0 72 0 72 142 0 142 0 1)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 23001 0 1 30 1 self)
			)
			(1
				(proc951_9 22701)
				(gSounds play: 22701 -1 0 0)
				(gSounds fade: 22701 98 1 30 0 0)
				(gSounds play: 13012 0 82 0)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

