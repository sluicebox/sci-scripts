;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12380)
(include sci.sh)
(use Main)

(public
	rm12v38 0
)

(instance rm12v38 of ShiversRoom
	(properties
		picture 12380
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
		nextRoom 12370
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12400
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12270
	)

	(method (init)
		(self createPoly: 29 144 80 107 80 27 212 27 212 107 243 144 29 144)
		(super init: &rest)
	)
)

