;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2350)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v35 0
)

(instance rm2v35 of ShiversRoom
	(properties
		picture 2160
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2091)
		)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 37
		nextRoom 2040
	)

	(method (init)
		(self createPoly: 1 0 0 143 45 143 44 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2660
	)

	(method (init)
		(self createPoly: 63 143 121 69 125 59 136 59 142 69 202 142)
		(super init: &rest)
	)
)

