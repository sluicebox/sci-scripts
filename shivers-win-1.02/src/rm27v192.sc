;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27192)
(include sci.sh)
(use Main)

(public
	rm27v192 0
)

(instance rm27v192 of ShiversRoom
	(properties
		picture 27192
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
		nextRoom 27200
	)

	(method (init)
		(self createPoly: 89 142 119 54 144 54 174 142 90 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27191
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27193
	)
)

