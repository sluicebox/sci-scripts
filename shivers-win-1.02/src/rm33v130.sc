;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33130)
(include sci.sh)
(use Main)

(public
	rm33v130 0
)

(instance rm33v130 of ShiversRoom
	(properties
		picture 33130
	)

	(method (init)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33070
	)

	(method (init)
		(self createPoly: 220 0 265 0 265 144 220 144 220 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33220
	)
)

