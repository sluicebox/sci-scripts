;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4410)
(include sci.sh)
(use Main)

(public
	rm4v410 0
)

(instance rm4v410 of ShiversRoom
	(properties
		picture 4140
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4400
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4400
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4430
	)

	(method (init)
		(self createPoly: 76 120 104 94 104 55 158 55 158 93 183 118)
		(super init: &rest)
	)
)

