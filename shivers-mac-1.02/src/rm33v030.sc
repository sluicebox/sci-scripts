;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33030)
(include sci.sh)
(use Main)
(use n951)

(public
	rm33v030 0
)

(instance rm33v030 of ShiversRoom
	(properties
		picture 33030
	)

	(method (init)
		(if (IsFlag 75)
			(self picture: 33031)
		)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33040
	)

	(method (init)
		(self
			createPoly:
				33
				141
				43
				119
				99
				114
				101
				32
				165
				32
				165
				113
				226
				118
				228
				128
				236
				131
				237
				142
				33
				142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33270
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33270
	)
)

