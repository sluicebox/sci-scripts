;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33010)
(include sci.sh)
(use Main)

(public
	rm33v010 0
)

(instance rm33v010 of ShiversRoom
	(properties
		picture 33010
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33030
	)

	(method (init)
		(self createPoly: 42 142 92 26 178 26 238 142 43 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27124
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27124
	)
)

