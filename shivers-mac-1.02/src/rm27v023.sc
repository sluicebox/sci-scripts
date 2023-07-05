;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27023)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	rm27v023 0
)

(local
	local0
)

(instance rm27v023 of ShiversRoom
	(properties
		picture 27021
	)

	(method (init)
		(spSecretDoor init:)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and local0 (!= newRoomNumber 20160)) ; rm20v160
			(gSounds play: 12703 0 82 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20160
	)

	(method (init)
		(self createPoly: 50 21 63 132 194 135 205 20 51 20)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27022
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27020
	)
)

(instance spSecretDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 27021
		cycleSpeed 10
	)

	(method (init)
		(self createPoly: 50 21 63 132 194 135 205 20 51 20)
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
				(gSounds play: 12702 0 82 0)
				(spSecretDoor setCycle: End)
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

