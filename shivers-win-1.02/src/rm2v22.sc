;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2220)
(include sci.sh)
(use Main)

(public
	rm2v22 0
)

(instance rm2v22 of ShiversRoom
	(properties
		picture 2220
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
		nextRoom 2230
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2200
	)

	(method (init)
		(self
			createPoly:
				34
				142
				74
				120
				74
				104
				99
				58
				116
				47
				142
				47
				153
				53
				161
				61
				188
				122
				214
				142
		)
		(super init: &rest)
	)
)

