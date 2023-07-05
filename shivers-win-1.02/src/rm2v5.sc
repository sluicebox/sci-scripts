;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2050)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v5 0
)

(instance rm2v5 of ShiversRoom
	(properties
		picture 2050
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2051)
		)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2350
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 220
		nextRoom 2040
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2790
	)

	(method (init)
		(if (not (IsFlag 2))
			(= nextRoom 2070)
		)
		(self createPoly: 60 142 120 70 141 70 201 142)
		(super init: &rest)
	)
)

