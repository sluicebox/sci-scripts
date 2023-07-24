;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33040)
(include sci.sh)
(use Main)
(use n951)

(public
	rm33v040 0
)

(instance rm33v040 of ShiversRoom
	(properties
		picture 33040
	)

	(method (init)
		(ClearFlag 43)
		(if (IsFlag 75)
			(self picture: 33041)
		)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33050
	)

	(method (init)
		(self
			createPoly: 86 142 113 100 113 50 154 50 154 99 154 102 180 142 86 142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33260
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33260
	)
)

