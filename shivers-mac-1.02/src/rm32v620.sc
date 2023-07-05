;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32620)
(include sci.sh)
(use Main)

(public
	rm32v620 0
)

(instance rm32v620 of ShiversRoom
	(properties
		picture 32620
	)

	(method (init)
		(efExitBack init: 8)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32610
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 32120
	)

	(method (init)
		(self createPoly: 34 0 34 96 151 88 187 89 231 95 231 1 36 1)
		(super init: &rest)
	)
)

