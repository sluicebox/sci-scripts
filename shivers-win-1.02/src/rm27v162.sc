;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27162)
(include sci.sh)
(use Main)

(public
	rm27v162 0
)

(instance rm27v162 of ShiversRoom
	(properties
		picture 27162
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
		nextRoom 27152
	)

	(method (init)
		(self createPoly: 89 142 107 32 167 32 178 142 89 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27161
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27163
	)
)

