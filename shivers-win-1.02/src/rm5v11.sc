;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5110)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm5v11 0
)

(instance rm5v11 of ShiversRoom
	(properties
		picture 5050
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(vButton init:)
		(pDoor init:)
		(super init: &rest)
		(if (== gPrevRoomNum 5010) ; rm5v01
			(pWindow init:)
			(self setScript: sDoorSlideOpen)
		)
	)

	(method (newRoom newRoomNumber)
		(if (> newRoomNumber 6000)
			(proc951_10 10403)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 5120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 5150
	)

	(method (init)
		(self
			createPoly: 244 4 244 103 249 103 249 125 242 125 242 142 264 142 264 2
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6400
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
		view 5110
	)
)

(instance pWindow of Prop
	(properties
		view 5050
		cycleSpeed 15
	)

	(method (init)
		(self setPri: 0)
		(super init: &rest)
	)
)

(instance pDoor of Prop
	(properties
		view 5050
		loop 1
		cycleSpeed 15
	)

	(method (init)
		(if (== gPrevRoomNum 5010) ; rm5v01
			(self setPri: 0)
		else
			(self setPri: 25 setCel: 4)
		)
		(super init: &rest)
	)
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
				(efExitForward init: 3)
				(gGame handsOn:)
			)
		)
	)
)

