;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31361)
(include sci.sh)
(use Main)

(public
	rm31v361 0
)

(instance rm31v361 of ShiversRoom
	(properties
		picture 31361
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 31360
	)

	(method (init)
		(self createPoly: 0 0 262 0 262 144 0 144 0 0)
		(super init: &rest)
	)
)

