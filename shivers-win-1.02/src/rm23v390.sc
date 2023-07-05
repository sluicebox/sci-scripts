;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23390)
(include sci.sh)
(use Main)

(public
	rm23v390 0
)

(instance rm23v390 of ShiversRoom
	(properties
		picture 23390
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPlaque init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23430
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23400
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 23600
	)

	(method (init)
		(self createPoly: 173 38 93 38 93 122 81 137 181 137 172 123 172 39)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 23950
	)

	(method (init)
		(self createPoly: 222 90 236 91 232 98 218 96 221 90)
		(super init: &rest)
	)
)

