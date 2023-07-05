;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4040)
(include sci.sh)
(use Main)

(public
	rm4v040 0
)

(instance rm4v040 of ShiversRoom
	(properties
		picture 4210
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 222
		nextRoom 4050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4020
	)

	(method (init)
		(self
			createPoly: 89 111 121 78 124 62 130 59 140 62 143 72 143 77 174 111
		)
		(super init: &rest)
	)
)

