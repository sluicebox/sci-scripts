;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13600)
(include sci.sh)
(use Main)

(public
	rm13v600 0
)

(instance rm13v600 of ShiversRoom
	(properties
		picture 13121
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13018
	)

	(method (init)
		(self createPoly: 90 99 90 44 120 47 120 94)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13013
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13012
	)
)

