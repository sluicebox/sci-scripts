;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8490)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm8v490 0
)

(instance rm8v490 of ShiversRoom
	(properties
		picture 8490
		invView 2
	)

	(method (init)
		(efExitUp init: 4)
		(efExitLeft init: 2)
		(super init: &rest)
		(cond
			((== gPrevRoomNum 8430) ; rm8v430
				(gCurRoom setScript: sStatueOpen)
			)
			((IsFlag 40)
				(pTop cel: (pTop lastCel:) init:)
				(pBottom cel: (pBottom lastCel:) init:)
				(self initRoom: 114 144 68 98)
				(inStatue init:)
			)
		)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 8480
	)

	(method (init)
		(self createPoly: 25 17 19 0 263 0 263 8 158 55 103 55)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8430
	)

	(method (init)
		(self createPoly: 19 0 53 101 7 143 0 143 0 0)
		(super init: &rest)
	)
)

(instance pTop of Prop
	(properties
		priority 75
		fixPriority 1
		view 8490
		cycleSpeed 18
	)
)

(instance pBottom of Prop
	(properties
		priority 5
		fixPriority 1
		view 8490
		loop 1
		cycleSpeed 18
	)
)

(instance inStatue of PotSpot
	(properties
		nsLeft 114
		nsTop 68
		nsRight 144
		nsBottom 98
	)
)

(instance sStatueOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= ticks 15)
			)
			(1
				(gSounds play: 10804 0 82 0)
				(pTop setCycle: End init:)
				(pBottom setCycle: End self init:)
				(gCurRoom initRoom: 114 144 68 98)
				(inStatue init:)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

