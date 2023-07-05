;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39250)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm39v250 0
)

(instance rm39v250 of ShiversRoom
	(properties
		picture 39250
	)

	(method (init)
		(ClearFlag 43)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(pDoorProp init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(gSounds stop: 13908)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39260
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 39200
	)

	(method (init)
		(self createPoly: 71 143 71 43 137 8 202 43 202 143)
		(super init: &rest)
	)
)

(instance pDoorProp of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 39250
		cycleSpeed 12
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
				(SetFlag 43)
				(= cycles 1)
			)
			(1
				(gSounds play: 13908 0 82 0)
				(pDoorProp setCycle: End self)
			)
			(2
				(efExitForward init: 3)
				(pDoorProp createPoly: 0 0 0 0 0 0 0 0 0 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

