;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4220)
(include sci.sh)
(use Main)

(public
	rm4v220 0
)

(instance rm4v220 of ShiversRoom
	(properties
		picture 4120
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
		nsRight 69
		nextRoom 4250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4200
	)

	(method (init)
		(self createPoly: 176 112 86 112 117 77 117 61 145 61 145 78)
		(super init: &rest)
	)
)

