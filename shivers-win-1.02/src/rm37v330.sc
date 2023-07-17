;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37330)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm37v330 0
)

(local
	local0
)

(instance rm37v330 of ShiversRoom
	(properties
		picture 37330
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efBox init: 3)
		(if (IsFlag 6)
			(spDoor init:)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (>= (spDoor cel:) 1) (< 1000 newRoomNumber -27536)) ; rm1v00
			(gSounds play: 10407 0 90 0)
		)
		(if (>= newRoomNumber -27536)
			(gSounds fade: 23701 0 5 16 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37320
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37340
	)

	(method (init)
		(self
			createPoly: 263 0 243 0 243 34 258 34 258 85 243 85 243 143 263 143
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 38011
	)

	(method (init)
		(self createPoly: 33 142 33 0 206 0 206 42 203 43 203 81 208 82 209 144)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efBox of ExitFeature
	(properties
		nextRoom 37360
	)

	(method (init)
		(self createPoly: 232 84 203 80 203 45 232 34 258 34 258 85)
		(super init: &rest)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 37331
		cycleSpeed 10
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

