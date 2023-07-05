;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8540)
(include sci.sh)
(use Main)

(public
	rm8v540 0
)

(instance rm8v540 of ShiversRoom
	(properties
		picture 8540
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8520
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8550
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8590
	)

	(method (init)
		(self
			createPoly:
				235
				140
				238
				98
				235
				96
				243
				1
				63
				1
				70
				96
				74
				96
				77
				142
				235
				140
		)
		(super init: &rest)
	)
)

