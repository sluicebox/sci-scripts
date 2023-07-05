;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39110)
(include sci.sh)
(use Main)

(public
	rm39v110 0
)

(instance rm39v110 of ShiversRoom
	(properties
		picture 39110
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForward init: 3)
		(if (== gPrevRoomNum 39080) ; rm39v080
			(gSounds fade: 23901 50 5 16 0 0)
			(gSounds fade: 23902 58 5 16 0 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 39190) ; rm39v190
			(gSounds fade: 23901 26 5 16 0 0)
			(gSounds fade: 23902 66 5 16 0 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39120
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39100
	)
)

(instance efForward of ExitFeature
	(properties
		nextRoom 39190
	)

	(method (init)
		(self createPoly: 70 115 68 50 181 50 181 110 89 118)
		(super init: &rest)
	)
)

