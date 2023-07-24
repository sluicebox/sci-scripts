;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31080)
(include sci.sh)
(use Main)

(public
	rm31v080 0
)

(instance rm31v080 of ShiversRoom
	(properties
		picture 31080
	)

	(method (init)
		(efExitBack init: 8)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 31430
	)

	(method (init)
		(self
			createPoly: 0 0 0 142 262 142 262 0 1 0 63 13 63 124 182 124 185 12 60 12
		)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 31800
	)

	(method (init)
		(self createPoly: 111 79 145 81 145 98 107 96 110 79)
		(super init: &rest)
	)
)

