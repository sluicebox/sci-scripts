;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16300)
(include sci.sh)
(use Main)

(public
	rm16v300 0
)

(instance rm16v300 of ShiversRoom
	(properties
		picture 16300
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 2)
		(efStairs init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16290
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16290
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16280
	)

	(method (init)
		(self createPoly: 95 142 161 142 161 72 116 1 29 1 29 98 95 116 95 142)
		(super init: &rest)
	)
)

(instance efStairs of ExitFeature
	(properties
		nextRoom 16640
	)

	(method (init)
		(self createPoly: 164 0 164 87 245 103 245 0 164 0)
		(super init: &rest)
	)
)

