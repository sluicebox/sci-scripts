;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32163)
(include sci.sh)
(use Main)

(public
	rm32v163 0
)

(instance rm32v163 of ShiversRoom
	(properties
		picture 32163
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 32161
	)

	(method (init)
		(self createPoly: 1 0 1 141 259 141 259 2 3 2)
		(super init: &rest)
	)
)

