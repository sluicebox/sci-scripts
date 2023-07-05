;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10040)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v040 0
)

(instance rm10v040 of ShiversRoom
	(properties
		picture 10040
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 10030) (!= newRoomNumber 10100) (IsFlag 6)) ; rm10v030, rm10v100
			(ClearFlag 6)
			(gSounds play: 10503 0 80 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10050
	)

	(method (init)
		(self createPoly: 121 62 70 19 100 5 165 2 201 18 149 62)
		(super init: &rest)
	)
)

