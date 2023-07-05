;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27020)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v020 0
)

(instance rm27v020 of ShiversRoom
	(properties
		picture 27020
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 5)
		(super newRoom: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 210
		nextRoom 27023
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 50
		nextRoom 27021
	)
)

