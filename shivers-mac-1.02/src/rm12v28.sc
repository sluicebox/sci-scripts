;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12280)
(include sci.sh)
(use Main)

(public
	rm12v28 0
)

(instance rm12v28 of ShiversRoom
	(properties
		picture 12280
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12270
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12330
	)

	(method (init)
		(self createPoly: 262 0 196 0 196 143 263 143 263 0)
		(super init: &rest)
	)
)

