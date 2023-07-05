;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27261)
(include sci.sh)
(use Main)

(public
	rm27v261 0
)

(instance rm27v261 of ShiversRoom
	(properties
		picture 27261
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
		nextRoom 27271
	)

	(method (init)
		(self createPoly: 64 143 87 40 133 40 151 142 65 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27260
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27262
	)
)

