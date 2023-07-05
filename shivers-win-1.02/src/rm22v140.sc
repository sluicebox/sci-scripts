;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22140)
(include sci.sh)
(use Main)

(public
	rm22v140 0
)

(instance rm22v140 of ShiversRoom
	(properties
		picture 22140
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22190
	)

	(method (init)
		(self createPoly: 102 61 162 61 162 141 102 141)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22350
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22380
	)
)

