;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10100)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm10v100 0
)

(local
	local0
)

(instance rm10v100 of ShiversRoom
	(properties
		picture 10100
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitBox init: 3)
		(if (IsFlag 6)
			(spDoor init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (>= (spDoor cel:) 4) (!= newRoomNumber 34030)) ; rm34v030
			(gSounds play: 10407 0 90 0)
		)
		(if (== newRoomNumber 34030) ; rm34v030
			(gSounds fadeChain:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10090
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 34030
	)

	(method (init)
		(self createPoly: 52 0 212 0 206 138 58 138 52 0)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitBox of ExitFeature
	(properties
		nextRoom 10101
	)

	(method (init)
		(self createPoly: 231 43 242 43 242 67 230 67 230 43)
		(super init: &rest)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 10110
		cycleSpeed 10
	)

	(method (init)
		(self createPoly: 52 0 212 0 206 138 58 138 52 0)
		(super init: &rest)
	)

	(method (doVerb)
		(= local0 1)
		(self setCycle: End)
		(gSounds play: 10406 0 90 0)
		(efExitForward init: 3)
	)
)

