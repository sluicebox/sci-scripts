;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9340)
(include sci.sh)
(use Main)
(use n951)

(public
	rm9v34 0
)

(instance rm9v34 of ShiversRoom
	(properties
		picture 9340
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (and (IsFlag 42) (== newRoomNumber 9300)) ; rm9v30
			(gSounds fade: 10908 8 15 8 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 9360
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9350
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9300
	)

	(method (init)
		(self createPoly: 61 142 78 123 78 62 203 62 203 142 61 142)
		(super init: &rest)
	)
)

