;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39010)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm39v010 0
)

(instance rm39v010 of ShiversRoom
	(properties
		picture 39010
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(proc951_1 7)
		(super init: &rest)
		(if (== gPrevRoomNum 10290) ; rm10v290
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39040
	)
)

(instance efForward of ExitFeature ; UNUSED
	(properties
		nextRoom 39010
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds fadeChain:)
				(gSounds play: 13911 0 82 self)
			)
			(1
				(gSounds interruptChain:)
				(= cycles 1)
			)
			(2
				(proc951_10 21001)
				(proc951_10 21002)
				(= cycles 1)
			)
			(3
				(if (proc951_11 7 39000)
					(proc951_9 23904)
					(gSounds play: 23904 -1 66 0)
				else
					(proc951_9 23901)
					(proc951_9 23902)
					(gSounds play: 23901 -1 0 0)
					(gSounds play: 23902 -1 0 0)
					(gSounds fade: 23901 58 5 16 0 0)
					(gSounds fade: 23902 26 5 16 0 0)
				)
				(ClearFlag 43)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

