;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31010)
(include sci.sh)
(use Main)
(use n31001)
(use Motion)
(use System)

(public
	rm31v010 0
)

(local
	local0
)

(instance rm31v010 of ShiversRoom
	(properties
		picture 31010
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(spDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 32230) ; rm32v230
			(if local0
				(gSounds play: 13218 0 82 0)
			)
		else
			(proc31001_1)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32230
	)

	(method (init)
		(self createPoly: 79 17 177 17 175 143 81 143 79 18)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31020
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31020
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 31010
		cycleSpeed 10
	)

	(method (init)
		(self createPoly: 79 17 177 17 175 143 81 143 79 18)
		(super init: &rest)
	)

	(method (doVerb)
		(= local0 1)
		(self setScript: sOpenDoor)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 13217 0 82 0)
				(spDoor setCycle: End)
				(= cycles 1)
			)
			(1
				(= seconds 2)
			)
			(2
				(efExitForward init: 3)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

