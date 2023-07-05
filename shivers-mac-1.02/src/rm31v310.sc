;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31310)
(include sci.sh)
(use Main)

(public
	rm31v310 0
)

(instance rm31v310 of ShiversRoom
	(properties
		picture 31310
		invView 2
	)

	(method (init)
		(self initRoom: 79 104 96 121)
		(psOnFloor init:)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance psOnFloor of PotSpot
	(properties
		nsLeft 79
		nsTop 96
		nsRight 104
		nsBottom 121
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31440
	)

	(method (init)
		(self createPoly: 100 104 164 104 167 4 97 4 100 103)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31300
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31300
	)
)

