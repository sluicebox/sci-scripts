;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13604)
(include sci.sh)
(use Main)

(public
	rm13v604 0
)

(instance rm13v604 of ShiversRoom
	(properties
		picture 13222
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13435
	)

	(method (init)
		(self createPoly: 122 99 122 45 157 49 157 95)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13436
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13437
	)
)

