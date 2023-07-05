;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18200)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm18v20 0
)

(instance rm18v20 of ShiversRoom
	(properties
		picture 18200
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
		(gCurRoom setScript: sEnter)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18190
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18220
	)

	(method (init)
		(self
			createPoly: 89 141 105 37 113 36 113 0 152 1 152 36 157 36 171 141
		)
		(super init: &rest)
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
				(gSounds adjChainVol: 35)
				(gSounds
					playChain: 21701 -1 -1 -2 21701 -1 -1 -2 21702 -1 -1 -2
				)
				(gGame handsOn:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

