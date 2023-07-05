;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7112)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm7v112 0
)

(instance rm7v112 of ShiversRoom
	(properties
		picture 7112
		invView 2
	)

	(method (init)
		(self initRoom: 141 182 103 137)
		(inCupboard init:)
		(spCupboard init:)
		(vBackOfCupboard init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitUp init: 4)
		(if (and (IsFlag 64) (not (IsFlag 8)))
			(self setScript: sOpenCupboard)
		else
			(spCupboard cel: 3)
		)
		(super init: &rest)
	)
)

(instance inCupboard of PotSpot
	(properties
		nsLeft 141
		nsTop 103
		nsRight 182
		nsBottom 137
	)
)

(instance spCupboard of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 7112
	)

	(method (init)
		(self createPoly: 134 81 199 81 189 142 133 142 133 81)
		(super init: &rest)
	)
)

(instance vBackOfCupboard of View
	(properties
		priority 1
		fixPriority 1
		view 7112
		loop 1
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 7111
	)

	(method (init)
		(self createPoly: 20 0 243 0 243 37 20 37 20 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7410
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7120
	)
)

(instance sOpenCupboard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gSounds play: 10708 0 82 0)
				(spCupboard setCycle: End)
				(= cycles 1)
			)
			(2
				(SetFlag 8)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

