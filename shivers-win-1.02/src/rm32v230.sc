;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32230)
(include sci.sh)
(use Main)
(use n951)
(use n32001)
(use System)

(public
	rm32v230 0
)

(instance rm32v230 of ShiversRoom
	(properties
		picture 32230
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (and (IsFlag 43) (== gPrevRoomNum 32460)) ; rm32v460
			(gSounds play: 13202 0 82 0)
			(ClearFlag 43)
		)
		(if (== gPrevRoomNum 31010) ; rm31v010
			(gCurRoom setScript: sEnter)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32670
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32460
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32220
	)

	(method (init)
		(self createPoly: 179 135 167 118 167 46 99 46 99 138 182 138)
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
				(gSounds fade: 23101 0 1 16 1 self)
			)
			(1
				(proc951_7 23201)
				(proc951_9 23201)
				(gSounds play: 13218 0 82 self)
			)
			(2
				(gSounds play: 23201 -1 82 0)
				(ClearFlag 43)
				(proc32001_0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

