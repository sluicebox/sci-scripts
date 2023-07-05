;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2250)
(include sci.sh)
(use Main)

(public
	rm2v25 0
)

(instance rm2v25 of ShiversRoom
	(properties
		picture 2250
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
		nextRoom 2240
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 2240
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2570
	)

	(method (init)
		(self
			createPoly:
				40
				142
				58
				127
				53
				44
				83
				16
				112
				8
				169
				8
				194
				15
				194
				104
				234
				143
		)
		(super init: &rest)
	)
)

