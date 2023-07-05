;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3350)
(include sci.sh)
(use Main)

(public
	rm3v350 0
)

(instance rm3v350 of ShiversRoom
	(properties
		picture 3350
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3340
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3360
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3410
	)

	(method (init)
		(self createPoly: 79 133 67 30 89 3 197 3 207 20 210 56 195 138)
		(super init: &rest)
	)
)

