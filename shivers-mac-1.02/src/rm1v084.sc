;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1084)
(include sci.sh)
(use Main)

(public
	rm1v084 0
)

(instance rm1v084 of ShiversRoom
	(properties
		picture 1084
	)

	(method (init)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 1080
	)

	(method (init)
		(self
			createPoly:
				0
				98
				0
				143
				263
				143
				263
				94
				172
				94
				172
				126
				62
				126
				62
				98
				1
				98
		)
		(super init: &rest)
	)
)

