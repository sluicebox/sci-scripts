;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11270)
(include sci.sh)
(use Main)

(public
	rm11v270 0
)

(instance rm11v270 of ShiversRoom
	(properties
		picture 11270
	)

	(method (init)
		(efExitRight init: 1)
		(efLadder init: 4)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11260
	)
)

(instance efLadder of ExitFeature
	(properties
		nextRoom 11310
	)

	(method (init)
		(self createPoly: 143 141 145 7 224 7 241 143)
		(super init: &rest)
	)
)

