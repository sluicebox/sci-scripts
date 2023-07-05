;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30170)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm30v170 0
)

(instance rm30v170 of ShiversRoom
	(properties
		picture 30170
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (== gPrevRoomNum 33310) ; rm33v310
			(ClearFlag 43)
			(gSounds play: 13012 0 82 0)
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30200
	)
)

(instance efExitForward of ExitFeature ; UNUSED
	(properties
		nextRoom 30190
	)

	(method (init)
		(self createPoly: 64 1 200 1 200 142 64 142 64 1)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 22701 0 1 30 1 self)
			)
			(1
				(proc951_10 22701)
				(= cycles 1)
			)
			(2
				(proc951_9 23001)
				(gSounds play: 23001 -1 0 0)
				(gSounds fade: 23001 82 1 30 0 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

