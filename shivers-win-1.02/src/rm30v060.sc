;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30060)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v060 0
)

(instance rm30v060 of ShiversRoom
	(properties
		picture 30060
	)

	(method (init)
		(if (IsFlag 85)
			(self picture: 30061)
		)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30120
	)

	(method (init)
		(self createPoly: 81 136 104 114 104 51 181 51 181 126 188 136 81 136)
		(super init: &rest)
	)
)

