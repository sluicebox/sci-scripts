;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13480)
(include sci.sh)
(use Main)

(public
	rm13v480 0
)

(instance rm13v480 of ShiversRoom
	(properties
		picture 13430
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13481
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13481
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13408
	)

	(method (init)
		(self createPoly: 64 142 64 24 200 24 200 142)
		(super init: &rest)
	)
)

