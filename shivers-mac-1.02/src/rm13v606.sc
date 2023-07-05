;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13606)
(include sci.sh)
(use Main)

(public
	rm13v606 0
)

(instance rm13v606 of ShiversRoom
	(properties
		picture 13232
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
		(self createPoly: 118 99 118 47 151 50 151 93)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13435
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13434
	)
)

