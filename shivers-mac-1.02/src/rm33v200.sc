;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33200)
(include sci.sh)
(use Main)

(public
	rm33v200 0
)

(instance rm33v200 of ShiversRoom
	(properties
		picture 33200
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
		nextRoom 33210
	)

	(method (init)
		(self createPoly: 70 141 70 26 171 26 171 131 180 142 70 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33090
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33190
	)
)

