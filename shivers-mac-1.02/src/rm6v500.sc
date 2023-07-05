;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6500)
(include sci.sh)
(use Main)
(use n951)

(public
	rm6v500 0
)

(instance rm6v500 of ShiversRoom
	(properties
		picture 6500
	)

	(method (init)
		(if (and (== gPrevRoomNum 6260) (IsFlag 43)) ; rm6v260
			(ClearFlag 43)
			(gSounds play: 10712 0 40 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(efLeftForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6260
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6270
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6090
	)

	(method (init)
		(self createPoly: 188 133 156 75 67 73 58 83 56 133)
		(super init: &rest)
	)
)

(instance efLeftForward of ExitFeature
	(properties
		nextRoom 6100
	)

	(method (init)
		(self createPoly: 56 132 60 66 21 57 21 132)
		(super init: &rest)
	)
)

