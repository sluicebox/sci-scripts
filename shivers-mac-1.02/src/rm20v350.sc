;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20350)
(include sci.sh)
(use Main)

(public
	rm20v350 0
)

(instance rm20v350 of ShiversRoom
	(properties
		picture 20350
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
		nextRoom 20330
	)

	(method (init)
		(self createPoly: 29 127 244 127 213 62 150 22 118 22 58 63 29 127)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20360
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20360
	)
)

