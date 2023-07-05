;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4170)
(include sci.sh)
(use Main)

(public
	rm4v170 0
)

(instance rm4v170 of ShiversRoom
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
		nsRight 71
		nextRoom 4160
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4210
	)

	(method (init)
		(self createPoly: 84 116 107 91 107 52 155 52 156 90 180 113)
		(super init: &rest)
	)
)

