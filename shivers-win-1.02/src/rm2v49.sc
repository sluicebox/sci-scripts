;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2490)
(include sci.sh)
(use Main)
(use n951)

(public
	rm2v49 0
)

(instance rm2v49 of ShiversRoom
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
		nextRoom 2090
	)

	(method (init)
		(self createPoly: 199 143 0 143 0 0 95 0 95 106 104 108 147 118)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2080
	)
)

