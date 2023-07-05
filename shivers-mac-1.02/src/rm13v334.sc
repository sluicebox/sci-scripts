;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13334)
(include sci.sh)
(use Main)

(public
	rm13v334 0
)

(instance rm13v334 of ShiversRoom
	(properties
		picture 13890
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
		nextRoom 13335
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13335
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13338
	)

	(method (init)
		(self createPoly: 83 132 107 102 107 42 173 42 173 110 200 142 74 142)
		(super init: &rest)
	)
)

