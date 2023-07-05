;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32480)
(include sci.sh)
(use Main)

(public
	rm32v480 0
)

(instance rm32v480 of ShiversRoom
	(properties
		picture 32480
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32470
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32470
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32230
	)

	(method (init)
		(self createPoly: 172 138 159 120 159 56 95 56 95 122 80 140 173 140)
		(super init: &rest)
	)
)

