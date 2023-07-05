;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18230)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	rm18v23 0
)

(local
	local0
)

(instance rm18v23 of ShiversRoom
	(properties
		picture 18230
	)

	(method (init)
		(= local0 0)
		(door init:)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 17010
	)

	(method (init)
		(self createPoly: 44 143 44 0 149 0 149 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18210
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18210
	)
)

(instance door of ShiversProp
	(properties
		priority 255
		fixPriority 1
		view 18230
	)

	(method (doVerb)
		(gCurRoom setScript: sDoorOpen)
	)
)

(instance sDoorOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gSounds play: 11701 0 32 0)
				(door
					cycleSpeed: 12
					setCycle: End self
					createPoly: -1 -1 -1 -1 -1 -1
				)
			)
			(2
				(= seconds 1)
			)
			(3
				(efExitForward init: 9)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

