;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13441)
(include sci.sh)
(use Main)

(public
	rm13v441 0
)

(instance rm13v441 of ShiversRoom
	(properties
		picture 13800
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
		nextRoom 13440
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13440
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13437
	)

	(method (init)
		(self createPoly: 67 142 99 108 99 35 165 35 165 107 196 142)
		(super init: &rest)
	)
)

