;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3361)
(include sci.sh)
(use Main)
(use n951)

(public
	rm3v361 0
)

(instance rm3v361 of ShiversRoom
	(properties
		picture 3361
	)

	(method (init)
		(proc951_16 86)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 3360
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

