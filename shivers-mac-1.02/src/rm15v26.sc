;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15260)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm15v26 0
)

(instance rm15v26 of ShiversRoom
	(properties
		picture 15260
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(spDoor init:)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9620
	)

	(method (init)
		(self createPoly: 49 142 65 135 65 30 204 30 204 135 211 142)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 110
		fixPriority 1
		view 15260
		cycleSpeed 3
	)

	(method (init)
		(self createPoly: 49 142 65 135 65 30 204 30 204 135 211 142)
		(super init: &rest)
	)

	(method (doVerb)
		(self setScript: sDoorOpens)
	)
)

(instance sDoorOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 11501 0 98 0)
				(spDoor setCycle: End self)
			)
			(1
				(efExitForward init: 3)
				(SetFlag 43)
				(SetFlag 41)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

