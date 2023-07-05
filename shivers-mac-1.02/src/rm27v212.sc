;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27212)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm27v212 0
)

(local
	local0
)

(instance rm27v212 of ShiversRoom
	(properties
		picture 27212
	)

	(method (init)
		(efExitPuzzle init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(if (IsFlag 6)
			(spDoor init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (>= (spDoor cel:) 1) (!= newRoomNumber 34030)) ; rm34v030
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
		(self createPoly: 72 26 175 26 175 134 71 134 71 26)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitPuzzle of ExitFeature
	(properties
		nextRoom 27211
	)

	(method (init)
		(self createPoly: 205 56 205 71 234 71 234 55 205 55)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27210
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27213
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 27212
		loop 1
		cycleSpeed 20
	)

	(method (init)
		(self createPoly: 73 1 185 1 185 142 73 142 73 2)
		(super init: &rest)
	)

	(method (doVerb)
		(= local0 1)
		(self setCycle: End)
		(gSounds play: 10406 0 90 0)
		(efExitForward init: 3)
	)
)

