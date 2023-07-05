;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13448)
(include sci.sh)
(use Main)

(public
	rm13v448 0
)

(instance rm13v448 of ShiversRoom
	(properties
		picture 13998
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
		nextRoom 13449
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13449
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13444
	)

	(method (init)
		(self createPoly: 65 143 81 127 81 35 163 35 163 108 194 142)
		(super init: &rest)
	)
)

