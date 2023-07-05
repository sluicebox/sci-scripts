;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40005)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm40v005 0
)

(instance rm40v005 of ShiversRoom
	(properties
		picture 40280
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(ClearFlag 43)
		(hsDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 18100) ; rm18v10
			(gSounds fade: 24001 0 2 40 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 18100
	)

	(method (init)
		(self
			createPoly:
				93
				136
				184
				136
				183
				87
				178
				66
				173
				50
				162
				33
				139
				8
				121
				24
				111
				39
				102
				55
				98
				70
				95
				85
				93
				136
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40010
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40010
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self
			createPoly:
				93
				136
				184
				136
				183
				87
				178
				66
				173
				50
				162
				33
				139
				8
				121
				24
				111
				39
				102
				55
				98
				70
				95
				85
				93
				136
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom setScript: sOpenDoor)
	)
)

(instance pDoor of Prop
	(properties
		view 40280
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hsDoor dispose:)
				(pDoor init: setPri: 25 1 cycleSpeed: 15 setCycle: End)
				(gSounds play: 11801 0 82 self)
			)
			(1
				(efExitForward init: 3)
				(SetFlag 43)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

