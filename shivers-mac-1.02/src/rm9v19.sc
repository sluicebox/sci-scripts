;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9190)
(include sci.sh)
(use Main)

(public
	rm9v19 0
)

(instance rm9v19 of ShiversRoom
	(properties
		picture 9190
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
		nextRoom 9180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9160
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9630
	)

	(method (init)
		(self createPoly: 91 127 91 60 185 60 185 123 191 142 82 142)
		(super init: &rest)
	)
)

