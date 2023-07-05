;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13601)
(include sci.sh)
(use Main)

(public
	rm13v601 0
)

(instance rm13v601 of ShiversRoom
	(properties
		picture 13212
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
		nextRoom 13013
	)

	(method (init)
		(self createPoly: 152 99 119 93 119 49 152 45)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13019
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13018
	)
)

