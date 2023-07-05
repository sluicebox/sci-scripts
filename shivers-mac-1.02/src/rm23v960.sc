;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23960)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v960 0
)

(instance rm23v960 of ShiversRoom
	(properties
		picture 23960
	)

	(method (init)
		(proc951_16 50)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 23310
	)

	(method (init)
		(self createPoly: 0 0 0 142 262 142 262 0 1 0)
		(super init: &rest)
	)
)

