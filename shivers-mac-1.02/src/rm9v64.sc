;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9640)
(include sci.sh)
(use Main)

(public
	rm9v64 0
)

(instance rm9v64 of ShiversRoom
	(properties
		picture 9640
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 9230
	)

	(method (init)
		(self
			createPoly:
				0
				0
				20
				20
				243
				20
				243
				123
				20
				123
				20
				20
				0
				0
				0
				143
				263
				143
				263
				0
		)
		(super init: &rest)
	)
)

