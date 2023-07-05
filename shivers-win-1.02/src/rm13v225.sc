;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13225)
(include sci.sh)
(use Main)

(public
	rm13v225 0
)

(instance rm13v225 of ShiversRoom
	(properties
		picture 13995
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
		nextRoom 13224
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13224
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13223
	)

	(method (init)
		(self createPoly: 65 143 81 127 81 35 163 35 163 108 194 142)
		(super init: &rest)
	)
)

