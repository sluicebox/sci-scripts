;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37182)
(include sci.sh)
(use Main)
(use n951)
(use Rev)
(use Motion)
(use System)

(public
	rm37v182 0
)

(instance rm37v182 of ShiversRoom
	(properties
		picture 37182
	)

	(method (init)
		(efExitBack1 init: 8)
		(efExitBack2 init: 8)
		(pPendulum init:)
		(pClockFace init:)
		(pClockWind init:)
		(super init: &rest)
	)
)

(instance efExitBack1 of ExitFeature
	(properties
		nextRoom 37180
	)

	(method (init)
		(self createPoly: 1 0 1 141 74 141 74 1 2 1)
		(super init: &rest)
	)
)

(instance efExitBack2 of ExitFeature
	(properties
		nextRoom 37180
	)

	(method (init)
		(self createPoly: 185 0 185 142 263 142 263 0 186 0)
		(super init: &rest)
	)
)

(instance pPendulum of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 37182
		loop 2
		cycleSpeed 10
	)
)

(instance pClockFace of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 37182
		loop 1
		cycleSpeed 10
	)
)

(instance pClockWind of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 37182
		cycleSpeed 8
	)

	(method (doVerb)
		(proc951_16 129)
		(gCurRoom setScript: sWindClock)
	)
)

(instance sWindClock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc951_9 13703)
				(proc951_9 13708)
				(proc951_9 13706)
				(pClockWind setCycle: Fwd)
				(gSounds play: 13703 0 82 self)
			)
			(1
				(pClockWind setCycle: 0)
				(= cycles 1)
			)
			(2
				(gSounds play: 13706 -1 82 0)
				(gSounds play: 13708 -1 82 0)
				(pClockWind setCycle: Rev)
				(pClockFace setCycle: Fwd)
				(pPendulum setCycle: Fwd)
				(= seconds (Random 4 6))
			)
			(3
				(gSounds stop: 13708)
				(gSounds stop: 13706)
				(pClockWind setCycle: 0)
				(pClockFace setCycle: 0)
				(pPendulum setCycle: 0)
				(= cycles 1)
			)
			(4
				(gSounds stop: 13706)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

