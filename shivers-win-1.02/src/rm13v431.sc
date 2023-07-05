;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13431)
(include sci.sh)
(use Main)

(public
	rm13v431 0
)

(instance rm13v431 of ShiversRoom
	(properties
		picture 13370
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
		nextRoom 13430
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13430
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13429
	)

	(method (init)
		(self createPoly: 46 143 46 11 197 11 197 130 209 142)
		(super init: &rest)
	)
)

