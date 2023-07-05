;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32220)
(include sci.sh)
(use Main)

(public
	rm32v220 0
)

(instance rm32v220 of ShiversRoom
	(properties
		picture 32220
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
		nextRoom 32200
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32280
	)

	(method (init)
		(self createPoly: 212 0 262 0 262 144 212 144 212 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32290
	)

	(method (init)
		(self createPoly: 180 135 166 119 166 48 109 47 108 117 102 134 178 134)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 32810
	)

	(method (init)
		(self createPoly: 24 129 45 144 54 138 35 122 25 129)
		(super init: &rest)
	)
)

