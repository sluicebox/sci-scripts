;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30380)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v380 0
)

(instance rm30v380 of ShiversRoom
	(properties
		picture 30380
	)

	(method (init)
		(if (IsFlag 85)
			(self picture: 30381)
		)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 30390
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30370
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30340
	)

	(method (init)
		(self
			createPoly:
				120
				50
				189
				50
				189
				122
				213
				144
				109
				144
				114
				130
				118
				130
				118
				57
		)
		(super init: &rest)
	)
)

