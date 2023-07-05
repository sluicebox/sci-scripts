;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27092)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm27v092 0
)

(local
	local0
)

(instance rm27v092 of ShiversRoom
	(properties
		picture 27092
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 2)
		(if (IsFlag 26)
			(spDoor init:)
			(if (== gPrevRoomNum 27090) ; rm27v090
				(spDoor doVerb:)
			)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and local0 (!= newRoomNumber 28000)) ; rm28v000
			(gSounds play: 12708 0 82 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 28000
	)

	(method (init)
		(self createPoly: 99 19 161 19 161 134 100 135 99 19)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27091
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27090
	)

	(method (init)
		(self createPoly: 0 0 53 0 53 142 0 142 0 0)
		(super init: &rest)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 27920
		cycleSpeed 10
	)

	(method (init)
		(self createPoly: 99 19 161 19 161 134 100 135 99 19)
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

