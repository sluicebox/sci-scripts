;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23311)
(include sci.sh)
(use Main)

(public
	rm23v311 0
)

(instance rm23v311 of ShiversRoom
	(properties
		picture 23311
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 23310
	)

	(method (init)
		(self createPoly: -2 0 0 1 0 142 262 142 262 0 0 0)
		(super init: &rest)
	)
)

