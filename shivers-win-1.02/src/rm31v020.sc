;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31020)
(include sci.sh)
(use Main)
(use n951)
(use n31001)
(use System)

(public
	rm31v020 0
)

(instance rm31v020 of ShiversRoom
	(properties
		picture 31020
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
		(if (== gPrevRoomNum 32450) ; rm32v450
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31060
	)

	(method (init)
		(self createPoly: 51 130 214 130 214 15 49 15 49 130 51 130)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31010
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31010
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fade: 23201 0 1 16 1 self)
				(gSounds interruptChain:)
			)
			(1
				(proc951_10 23201)
				(gSounds play: 13218 0 82 self)
			)
			(2
				(proc951_9 23101)
				(gSounds play: 23101 -1 0 0)
				(gSounds fade: 23101 90 5 16 0 0)
				(= cycles 1)
			)
			(3
				(ClearFlag 43)
				(proc31001_0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

