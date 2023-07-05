;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1241)
(include sci.sh)
(use Main)

(public
	rm1v241 0
)

(instance rm1v241 of ShiversRoom
	(properties
		picture 1241
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1240
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1231
	)

	(method (init)
		(self
			createPoly:
				127
				142
				125
				101
				94
				77
				2
				33
				2
				20
				101
				24
				101
				61
				174
				92
				262
				122
				262
				142
		)
		(super init: &rest)
	)
)

