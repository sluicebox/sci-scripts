;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28210)
(include sci.sh)
(use Main)
(use n951)

(public
	rm28v210 0
)

(instance rm28v210 of ShiversRoom
	(properties
		picture 28210
	)

	(method (init)
		(proc951_16 110)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 28040
	)

	(method (init)
		(self
			createPoly:
				0
				0
				20
				20
				20
				123
				243
				123
				243
				20
				20
				20
				0
				0
				263
				0
				263
				143
				0
				143
		)
		(super init: &rest)
	)
)

