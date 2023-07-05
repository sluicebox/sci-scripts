;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14090)
(include sci.sh)
(use Main)

(public
	rm14v9 0
)

(instance rm14v9 of ShiversRoom
	(properties
		picture 14090
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
		nextRoom 14100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 14120
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 14300
	)

	(method (init)
		(self createPoly: 73 116 69 30 82 20 101 16 117 16 131 23 131 126)
		(super init: &rest)
	)
)

