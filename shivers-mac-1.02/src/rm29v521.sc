;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29521)
(include sci.sh)
(use Main)

(public
	rm29v521 0
)

(instance rm29v521 of ShiversRoom
	(properties
		picture 29521
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 29520
	)

	(method (init)
		(self createPoly: 1 1 262 1 262 141 1 141 1 1)
		(super init: &rest)
	)
)

