;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33220)
(include sci.sh)
(use Main)
(use n951)

(public
	rm33v220 0
)

(instance rm33v220 of ShiversRoom
	(properties
		picture 33220
	)

	(method (init)
		(ClearFlag 43)
		(if (IsFlag 75)
			(self picture: 33221)
		)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33240
	)

	(method (init)
		(self createPoly: 88 142 118 95 118 57 147 57 147 95 182 142 89 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33230
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33070
	)
)

