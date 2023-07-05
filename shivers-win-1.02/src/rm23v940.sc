;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23940)
(include sci.sh)
(use Main)
(use n951)

(public
	rm23v940 0
)

(instance rm23v940 of ShiversRoom
	(properties
		picture 23940
	)

	(method (init)
		(proc951_16 51)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 23430
	)

	(method (init)
		(self createPoly: 0 0 0 142 262 142 262 0 1 0)
		(super init: &rest)
	)
)

