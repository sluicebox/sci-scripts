;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4160)
(include sci.sh)
(use Main)

(public
	rm4v160 0
)

(instance rm4v160 of ShiversRoom
	(properties
		picture 4310
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 220
		nextRoom 4170
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 4180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 4140
	)

	(method (init)
		(self createPoly: 84 116 107 91 107 52 155 52 156 90 180 113)
		(super init: &rest)
	)
)

