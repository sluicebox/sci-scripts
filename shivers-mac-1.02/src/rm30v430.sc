;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30430)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm30v430 0
)

(local
	local0
)

(instance rm30v430 of ShiversRoom
	(properties
		picture 30430
	)

	(method (init)
		(= local0 1)
		(pDoor init:)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30440
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30440
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32010
	)

	(method (init)
		(self createPoly: 98 33 146 33 146 142 98 142 98 33)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance pDoor of ShiversProp
	(properties
		priority 120
		fixPriority 1
		view 30430
		cycleSpeed 18
	)

	(method (init)
		(self createPoly: 97 32 162 32 162 142 96 142 96 32)
		(super init: &rest)
	)

	(method (doVerb)
		(if local0
			(gGame handsOff:)
			(SetFlag 43)
			(gSounds play: 13013 0 82 0)
			(self setCycle: End)
			(= local0 0)
			(gGame handsOn:)
			(efExitForward init: 3)
		)
	)
)

