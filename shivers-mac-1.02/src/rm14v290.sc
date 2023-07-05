;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14290)
(include sci.sh)
(use Main)

(public
	rm14v290 0
)

(instance rm14v290 of ShiversRoom
	(properties
		picture 14290
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
		nextRoom 14190
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14180
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14170
	)

	(method (init)
		(self createPoly: 96 88 64 57 101 32 129 61)
		(super init: &rest)
	)
)

