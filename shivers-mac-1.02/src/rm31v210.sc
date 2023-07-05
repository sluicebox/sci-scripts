;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31210)
(include sci.sh)
(use Main)

(public
	rm31v210 0
)

(instance rm31v210 of ShiversRoom
	(properties
		picture 31210
	)

	(method (init)
		(efExitDown init: 5)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 31400
	)

	(method (init)
		(self createPoly: 28 142 28 108 228 108 228 142 28 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31220
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31180
	)
)

