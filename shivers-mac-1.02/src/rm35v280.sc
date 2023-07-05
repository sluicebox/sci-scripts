;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35280)
(include sci.sh)
(use Main)
(use n951)

(public
	rm35v280 0
)

(instance rm35v280 of ShiversRoom
	(properties
		picture 35280
	)

	(method (init)
		(if (IsFlag 29)
			(self picture: 35284)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35180
	)

	(method (init)
		(self createPoly: 127 60 127 125 236 125 236 59 127 59)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35320
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35110
	)
)

