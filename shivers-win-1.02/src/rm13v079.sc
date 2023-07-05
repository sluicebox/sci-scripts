;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13079)
(include sci.sh)
(use Main)

(public
	rm13v079 0
)

(instance rm13v079 of ShiversRoom
	(properties
		picture 13770
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
		nextRoom 13080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13081
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13077
	)

	(method (init)
		(self createPoly: 64 142 104 97 104 47 157 47 157 100 193 142)
		(super init: &rest)
	)
)

