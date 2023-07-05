;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5030)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	rm5v03 0
)

(instance rm5v03 of ShiversRoom
	(properties
		picture 5060
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(vButton init:)
		(pDoor init:)
		(super init: &rest)
		(if (== gPrevRoomNum 5130) ; rm5v13
			(pWindow init:)
			(self setScript: sDoorSlideOpen)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 5050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 5020
	)

	(method (init)
		(self
			createPoly:
				244
				4
				244
				103
				249
				103
				249
				125
				242
				125
				242
				142
				264
				142
				264
				2
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4600
	)

	(method (init)
		(self createPoly: 59 18 60 124 201 124 204 18)
		(super init: &rest)
	)
)

(instance vButton of View
	(properties
		priority 25
		fixPriority 1
		view 5030
	)
)

(instance pWindow of ShiversProp
	(properties
		view 5060
		cycleSpeed 15
	)

	(method (init)
		(self setPri: 0)
		(super init: &rest)
	)

	(method (doVerb))
)

(instance pDoor of ShiversProp
	(properties
		view 5060
		loop 1
		cycleSpeed 15
	)

	(method (init)
		(if (== gPrevRoomNum 5130) ; rm5v13
			(self setPri: 0)
		else
			(self setPri: 25 1 setCel: 4)
		)
		(super init: &rest)
	)

	(method (doVerb))
)

(instance sDoorSlideOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10503 0 90 self)
				(pWindow setPri: 24 setCycle: End self)
			)
			(1
				(pDoor setPri: 25 setCycle: End)
			)
			(2
				(gGame handsOn:)
			)
		)
	)
)

