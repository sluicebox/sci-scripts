;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28020)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	rm28v020 0
)

(local
	local0
)

(instance rm28v020 of ShiversRoom
	(properties
		picture 28020
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(spDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 27091) ; rm27v091
			(gSounds fade: 22801 0 4 10 1 0)
		)
		(if (and local0 (!= newRoomNumber 27091)) ; rm27v091
			(gSounds play: 12708 0 82 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 28010
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 28040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27091
	)

	(method (init)
		(self createPoly: 110 143 110 37 157 37 157 144)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 28020
		cycleSpeed 10
	)

	(method (init)
		(self createPoly: 110 143 110 37 157 37 157 144)
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
				(gSounds play: 12707 0 90 0)
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

