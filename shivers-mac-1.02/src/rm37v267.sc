;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37267)
(include sci.sh)
(use Main)

(public
	rm37v267 0
)

(instance rm37v267 of ShiversRoom
	(properties
		picture 37267
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 37251
	)

	(method (init)
		(self createPoly: 1 1 262 1 262 142 1 142 1 1)
		(super init: &rest)
	)
)

