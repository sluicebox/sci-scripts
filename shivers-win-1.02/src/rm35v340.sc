;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35340)
(include sci.sh)
(use Main)

(public
	rm35v340 0
)

(instance rm35v340 of ShiversRoom
	(properties
		picture 35340
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 35180
	)

	(method (init)
		(self
			createPoly: 0 0 0 142 262 142 262 0 1 0 43 44 43 122 213 122 213 42 42 42
		)
		(super init: &rest)
	)
)

