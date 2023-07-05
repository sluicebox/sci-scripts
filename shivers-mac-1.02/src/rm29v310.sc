;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29310)
(include sci.sh)
(use Main)

(public
	rm29v310 0
)

(instance rm29v310 of ShiversRoom
	(properties
		picture 29310
	)

	(method (init)
		(efExitBack init: 5)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 29140
	)

	(method (init)
		(self createPoly: 1 1 260 1 260 140 1 140 1 1)
		(super init: &rest)
	)
)

