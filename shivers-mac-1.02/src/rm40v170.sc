;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40170)
(include sci.sh)
(use Main)

(public
	rm40v170 0
)

(instance rm40v170 of ShiversRoom
	(properties
		picture 40140
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40150
	)

	(method (init)
		(self
			createPoly:
				20
				126
				20
				111
				30
				113
				65
				98
				82
				100
				103
				93
				118
				98
				150
				0
				226
				0
				206
				126
				20
				126
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40160
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40160
	)
)

