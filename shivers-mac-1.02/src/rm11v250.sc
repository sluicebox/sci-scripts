;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11250)
(include sci.sh)
(use Main)

(public
	rm11v250 0
)

(instance rm11v250 of ShiversRoom
	(properties
		picture 11250
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efLadder init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11320
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11240
	)
)

(instance efLadder of ExitFeature
	(properties
		nextRoom 11270
	)

	(method (init)
		(self createPoly: 180 2 102 143 146 142 210 3)
		(super init: &rest)
	)
)

