;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27150)
(include sci.sh)
(use Main)

(public
	rm27v150 0
)

(instance rm27v150 of ShiversRoom
	(properties
		picture 27150
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
		nextRoom 27160
	)

	(method (init)
		(self createPoly: 91 142 108 35 170 35 178 142 92 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27153
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27151
	)
)

