;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13515)
(include sci.sh)
(use Main)

(public
	rm13v515 0
)

(instance rm13v515 of ShiversRoom
	(properties
		picture 13820
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13514
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13512
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13517
	)

	(method (init)
		(self createPoly: 73 142 108 102 108 43 164 43 164 102 209 142)
		(super init: &rest)
	)
)

