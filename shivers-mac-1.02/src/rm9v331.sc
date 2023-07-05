;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9331)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v331 0
)

(instance rm9v331 of ShiversRoom
	(properties
		picture 9331
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitDown init: 5)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 42) (== newRoomNumber 9690)) ; rm9v69
			(gSounds fade: 10908 0 20 3 1 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9320
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9300
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 9330
	)

	(method (init)
		(self createPoly: 35 143 127 37 222 144)
		(super init: &rest)
	)
)

