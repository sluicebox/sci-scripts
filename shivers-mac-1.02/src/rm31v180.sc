;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31180)
(include sci.sh)
(use Main)

(public
	rm31v180 0
)

(instance rm31v180 of ShiversRoom
	(properties
		picture 31180
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
		nextRoom 31200
	)

	(method (init)
		(self createPoly: 48 15 48 127 214 127 214 14 48 14)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31210
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31190
	)
)

