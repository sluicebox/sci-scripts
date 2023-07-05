;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13013)
(include sci.sh)
(use Main)

(public
	rm13v013 0
)

(instance rm13v013 of ShiversRoom
	(properties
		picture 13200
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
		nextRoom 13011
	)

	(method (init)
		(self createPoly: 81 132 81 11 190 11 190 132)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13607
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13600
	)
)

