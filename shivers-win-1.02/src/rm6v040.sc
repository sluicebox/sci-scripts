;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6040)
(include sci.sh)
(use Main)
(use n951)

(public
	rm6v040 0
)

(instance rm6v040 of ShiversRoom
	(properties
		picture 6040
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 43)
			(ClearFlag 43)
			(if (== gPrevRoomNum 6030) ; rm6v030
				(gSounds play: 10614 0 40 0)
			else
				(gSounds play: 10712 0 40 0)
			)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(if (proc951_11 2 6000)
			(proc951_7 20608)
			(proc951_9 20608)
			(gSounds play: 20608 -1 32 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (proc951_11 2 6000)
			(if (== newRoomNumber 6280) ; rm6v280
				(gSounds stop: 20601)
			else
				(gSounds fade: 20608 0 5 5 1 0)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6270
	)

	(method (init)
		(if (or (== gPrevRoomNum 6030) (== gPrevRoomNum 6020)) ; rm6v030, rm6v020
			(= nextRoom 6030)
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6020
	)

	(method (init)
		(if (or (== gPrevRoomNum 6270) (== gPrevRoomNum 6260)) ; rm6v270, rm6v260
			(= nextRoom 6260)
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6280
	)

	(method (init)
		(self createPoly: 97 142 93 110 126 100 147 100 178 112 178 142)
		(super init: &rest)
	)
)

