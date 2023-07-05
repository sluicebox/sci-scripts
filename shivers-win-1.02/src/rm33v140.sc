;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33140)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm33v140 0
)

(instance rm33v140 of ShiversRoom
	(properties
		picture 33140
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (IsFlag 6)
			(spElevator init:)
			(self picture: 33141)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 34030) ; rm34v030
			(gSounds fade: 22701 0 3 40 1 0)
		)
		(if (and (>= (spElevator cel:) 4) (!= newRoomNumber 34030)) ; rm34v030
			(gSounds play: 10407 0 90 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 34030
	)

	(method (init)
		(self createPoly: 41 13 225 13 225 142 40 142 40 13)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33160
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33120
	)
)

(instance spElevator of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 33141
		cycleSpeed 10
	)

	(method (doVerb)
		(self setCycle: End self)
		(gSounds play: 10406 0 90 0)
		(efExitForward init: 3)
	)
)

