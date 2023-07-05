;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32161)
(include sci.sh)
(use Main)
(use n951)
(use n32001)
(use Motion)
(use System)

(public
	rm32v161 0
)

(instance rm32v161 of ShiversRoom
	(properties
		picture 32161
	)

	(method (init)
		(efExitBack1 init: 8)
		(efExitBack2 init: 8)
		(efExitPlaque init: 3)
		(if (not (IsFlag 73))
			(gSounds fade: 23201 0 2 2 1 0)
			(gSounds fadeChain:)
		)
		(if (IsFlag 73)
			(efBasket init: 3)
			(spGuillotine cel: (spGuillotine lastCel:) init:)
		else
			(spPin init:)
			(spGuillotine init:)
		)
		(super init: &rest)
	)
)

(instance spPin of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 32161
		loop 1
	)

	(method (doVerb)
		(proc951_16 165)
		(efBasket init: 3)
		(gCurRoom setScript: sPullPin)
	)
)

(instance spGuillotine of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 32161
	)

	(method (init)
		(self createPoly: -1 -1 -1 -1 -1 -1 -1 -1)
		(super init: &rest)
	)
)

(instance sPullPin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc951_9 13216)
				(gSounds play: 13216 0 127 0)
				(spPin setCycle: End)
				(spGuillotine setCycle: End self)
			)
			(1
				(proc951_9 23201)
				(= cycles 1)
			)
			(2
				(= seconds 1)
			)
			(3
				(gSounds play: 23201 -1 82 0)
				(proc32001_0)
				(SetFlag 73)
				(proc951_16 165)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 32800
	)

	(method (init)
		(self createPoly: 17 85 19 135 21 144 55 139 53 97 49 82 17 84)
		(super init: &rest)
	)
)

(instance efExitBack1 of ExitFeature
	(properties
		nextRoom 32160
	)

	(method (init)
		(self createPoly: 55 1 55 142 103 142 103 1 56 1)
		(super init: &rest)
	)
)

(instance efExitBack2 of ExitFeature
	(properties
		nextRoom 32160
	)

	(method (init)
		(self createPoly: 183 0 183 15 167 16 167 142 219 142 219 0 185 0)
		(super init: &rest)
	)
)

(instance efBasket of ExitFeature
	(properties
		nextRoom 32163
	)

	(method (init)
		(self createPoly: 114 116 114 142 157 142 157 115 114 115)
		(super init: &rest)
	)
)

