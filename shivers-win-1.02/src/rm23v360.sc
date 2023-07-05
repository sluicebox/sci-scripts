;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23360)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v360 0
)

(instance rm23v360 of ShiversRoom
	(properties
		picture 23360
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 5)
		(super newRoom: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23350
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23350
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23380
	)

	(method (init)
		(self createPoly: 89 45 89 100 187 100 200 61 200 40 89 40 89 48)
		(super init: &rest)
	)
)

