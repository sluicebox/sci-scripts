;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23920)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v920 0
)

(instance rm23v920 of ShiversRoom
	(properties
		picture 23920
	)

	(method (init)
		(proc951_16 52)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 23550
	)

	(method (init)
		(self createPoly: 0 0 0 142 262 142 262 0 1 0)
		(super init: &rest)
	)
)

