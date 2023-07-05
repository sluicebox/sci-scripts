;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1123)
(include sci.sh)
(use Main)

(public
	rm1v123 0
)

(instance rm1v123 of ShiversRoom
	(properties
		picture 1123
	)

	(method (init)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1122
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1111
	)

	(method (init)
		(self
			createPoly:
				27
				115
				38
				90
				52
				71
				68
				62
				79
				58
				93
				61
				107
				69
				116
				83
				121
				98
				204
				116
				212
				129
				182
				138
				62
				108
		)
		(super init: &rest)
	)
)

