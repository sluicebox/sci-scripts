;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13017)
(include sci.sh)
(use Main)

(public
	rm13v017 0
)

(instance rm13v017 of ShiversRoom
	(properties
		picture 13160
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
		nextRoom 13015
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13014
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13018
	)

	(method (init)
		(self createPoly: 106 96 106 47 152 47 152 97)
		(super init: &rest)
	)
)

