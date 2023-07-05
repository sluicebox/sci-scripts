;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4140)
(include sci.sh)
(use Main)

(public
	rm4v140 0
)

(instance rm4v140 of ShiversRoom
	(properties
		picture 4180
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
		nextRoom 4150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 4150
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4100
	)

	(method (init)
		(self createPoly: 74 127 107 107 95 37 166 37 166 102 184 126)
		(super init: &rest)
	)
)

