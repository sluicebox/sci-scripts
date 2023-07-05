;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18190)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm18v19 0
)

(instance rm18v19 of ShiversRoom
	(properties
		picture 18190
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(gCurRoom setScript: sEnter)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18160
	)

	(method (init)
		(self createPoly: 98 144 114 109 114 58 170 58 170 142)
		(super init: &rest)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds interruptChain:)
				(= cycles 1)
			)
			(1
				(proc951_9 21602)
				(gSounds play: 21602 -1 51 0)
				(gGame handsOn:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

