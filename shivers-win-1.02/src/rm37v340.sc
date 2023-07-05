;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37340)
(include sci.sh)
(use Main)

(public
	rm37v340 0
)

(instance rm37v340 of ShiversRoom
	(properties
		picture 37340
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efBox init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 37330
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 17 0 17 0 71 20 71 20 143 0 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 37350
	)
)

(instance efBox of ExitFeature
	(properties
		nextRoom 37360
	)

	(method (init)
		(self createPoly: 0 17 52 17 62 24 61 71 0 71)
		(super init: &rest)
	)
)

