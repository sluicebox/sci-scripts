;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23140)
(include sci.sh)
(use Main)

(public
	rm23v140 0
)

(instance rm23v140 of ShiversRoom
	(properties
		picture 23140
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 23080
	)

	(method (init)
		(self createPoly: 4 4 256 4 256 139 3 139 3 4)
		(super init: &rest)
	)
)

