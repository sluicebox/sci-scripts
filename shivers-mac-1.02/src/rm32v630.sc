;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32630)
(include sci.sh)
(use Main)

(public
	rm32v630 0
)

(instance rm32v630 of ShiversRoom
	(properties
		picture 32630
	)

	(method (init)
		(efExitBack init: 8)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32620
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 32130
	)

	(method (init)
		(self createPoly: 29 141 29 105 67 101 215 102 257 107 257 142 30 142)
		(super init: &rest)
	)
)

