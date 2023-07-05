;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32040)
(include sci.sh)
(use Main)

(public
	rm32v040 0
)

(instance rm32v040 of ShiversRoom
	(properties
		picture 32040
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32050
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32600
	)

	(method (init)
		(self
			createPoly:
				132
				123
				132
				110
				18
				108
				0
				116
				0
				139
				14
				137
				39
				132
				86
				131
				132
				123
		)
		(super init: &rest)
	)
)

