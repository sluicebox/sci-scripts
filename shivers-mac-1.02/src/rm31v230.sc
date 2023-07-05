;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31230)
(include sci.sh)
(use Main)

(public
	rm31v230 0
)

(instance rm31v230 of ShiversRoom
	(properties
		picture 31230
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
		nextRoom 31500
	)

	(method (init)
		(self createPoly: 220 116 143 116 143 13 218 13 220 116)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31240
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31240
	)
)

