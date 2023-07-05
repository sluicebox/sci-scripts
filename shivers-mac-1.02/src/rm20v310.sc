;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20310)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm20v310 0
)

(local
	local0
)

(instance rm20v310 of ShiversRoom
	(properties
		picture 20311
	)

	(method (init)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(spDoor init:)
		(if (IsFlag 18)
			(if (== gPrevRoomNum 20311) ; rm20v311
				(SetFlag 43)
				(gSounds play: 12001 0 82 0)
				(= local0 1)
				(spDoor setCycle: End)
				(efExitForward init: 3)
			else
				(efExitPuzzle init: 0)
			)
		else
			(efExitPuzzle init: 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 6)
		(if (>= newRoomNumber 21000)
			(gSounds fade: 22001 0 4 10 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 21360
	)

	(method (init)
		(self createPoly: 88 134 85 10 176 10 174 135)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20320
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20320
	)
)

(instance efExitPuzzle of ExitFeature
	(properties
		nextRoom 20311
	)

	(method (init)
		(self createPoly: 103 24 158 24 158 69 102 69)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 20311
		cycleSpeed 36
	)

	(method (init)
		(self createPoly: 88 134 85 10 176 10 174 135)
		(super init: &rest)
	)

	(method (doVerb)
		(if (IsFlag 18)
			(SetFlag 43)
			(gSounds play: 12001 0 82 0)
			(self createPoly: -1 -1 -1 -1 -1 -1 setCycle: End)
			(= local0 1)
			(efExitForward init: 3)
		)
	)
)

