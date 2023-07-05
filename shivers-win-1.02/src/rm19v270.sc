;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19270)
(include sci.sh)
(use Main)

(public
	rm19v270 0
)

(instance rm19v270 of ShiversRoom
	(properties
		picture 19270
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForwardLeft init: 3)
		(efForwardRight init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (< newRoomNumber 19260) ; rm19v260
			(gSounds fade: 21910 0 15 8 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 19260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 19280
	)
)

(instance efForwardLeft of ExitFeature
	(properties
		nextRoom 19030
	)

	(method (init)
		(self createPoly: 76 134 20 134 20 41 90 41 59 75 59 80)
		(super init: &rest)
	)
)

(instance efForwardRight of ExitFeature
	(properties
		nextRoom 19150
	)

	(method (init)
		(self createPoly: 186 136 211 79 211 77 173 41 243 41 242 137)
		(super init: &rest)
	)
)

