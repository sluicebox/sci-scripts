;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13134)
(include sci.sh)
(use Main)

(public
	rm13v134 0
)

(instance rm13v134 of ShiversRoom
	(properties
		picture 13274
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
		nextRoom 13132
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13133
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13020
	)

	(method (init)
		(self createPoly: 76 142 113 95 114 49 156 49 156 94 206 142)
		(super init: &rest)
	)
)

