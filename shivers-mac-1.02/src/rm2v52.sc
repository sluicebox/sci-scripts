;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2520)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v52 0
)

(instance rm2v52 of ShiversRoom
	(properties
		picture 2280
	)

	(method (init)
		(if (not (IsFlag 2))
			(self picture: 2281)
		)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 2380
	)

	(method (init)
		(self createPoly: 199 143 0 143 0 0 95 0 95 106 104 108 147 118)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2390
	)
)

