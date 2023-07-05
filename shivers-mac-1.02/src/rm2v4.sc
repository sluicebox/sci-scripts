;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2040)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v4 0
)

(instance rm2v4 of ShiversRoom
	(properties
		picture 2040
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2042)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 35
		nextRoom 2050
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 237
		nextRoom 2350
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2020
	)

	(method (init)
		(self
			createPoly: 59 142 114 81 113 61 122 55 141 55 150 61 152 83 210 142
		)
		(super init: &rest)
	)
)

