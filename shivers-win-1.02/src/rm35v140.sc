;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35140)
(include sci.sh)
(use Main)
(use n951)

(public
	rm35v140 0
)

(instance rm35v140 of ShiversRoom
	(properties
		picture 35140
	)

	(method (init)
		(if (IsFlag 29)
			(self picture: 35144)
		)
		(efExitDown init: 5)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 35100
	)

	(method (init)
		(self createPoly: 39 143 39 123 220 123 220 142 40 142)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35180
	)

	(method (init)
		(self createPoly: 127 59 228 59 228 128 127 128 127 60)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35130
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35200
	)
)

