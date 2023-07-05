;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27124)
(include sci.sh)
(use Main)

(public
	rm27v124 0
)

(instance rm27v124 of ShiversRoom
	(properties
		picture 27124
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
		nextRoom 27121
	)

	(method (init)
		(self createPoly: 82 136 191 136 225 4 55 4 82 135)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33020
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33020
	)
)

