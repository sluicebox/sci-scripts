;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38110)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm38v110 0
)

(instance rm38v110 of ShiversRoom
	(properties
		picture 38110
	)

	(method (init)
		(if (IsFlag 6)
			(spDoor init:)
		)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 9)
		(if (== newRoomNumber 38010) ; rm38v010
			(gSounds fadeChain:)
			(gSounds fade: 20601 0 15 8 1 0)
			(gSounds fade: 20603 0 15 8 1 0)
		)
		(if (and (>= (spDoor cel:) 1) (!= newRoomNumber 38010)) ; rm38v010
			(gSounds play: 10407 0 90 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 38100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 38130
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 38010
	)

	(method (init)
		(self createPoly: 56 0 57 142 211 142 213 0 57 0)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 38111
		loop 1
		cycleSpeed 14
	)

	(method (init)
		(self createPoly: 56 0 57 142 211 142 213 0 57 0)
		(super init: &rest)
	)

	(method (doVerb)
		(self setCycle: End)
		(gSounds play: 10406 0 90 0)
		(efExitForward init: 3)
	)
)

