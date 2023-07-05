;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22200)
(include sci.sh)
(use Main)
(use n951)

(public
	rm22v200 0
)

(instance rm22v200 of ShiversRoom
	(properties
		picture 22200
	)

	(method (init)
		(if (IsFlag 22)
			(self picture: 22201)
		)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22370
	)

	(method (init)
		(self createPoly: 73 143 77 137 77 51 184 51 184 142 74 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22190
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22190
	)
)

