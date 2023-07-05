;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27101)
(include sci.sh)
(use Main)

(public
	rm27v101 0
)

(instance rm27v101 of ShiversRoom
	(properties
		picture 27102
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27071
	)

	(method (init)
		(self createPoly: 75 141 109 50 157 50 182 141 76 141 76 138)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27100
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27102
	)
)

