;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40350)
(include sci.sh)
(use Main)

(public
	rm40v350 0
)

(instance rm40v350 of ShiversRoom
	(properties
		picture 40170
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40370
	)

	(method (init)
		(self createPoly: 96 125 147 125 147 1 97 1 96 124)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40360
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40360
	)
)

