;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27100)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v100 0
)

(instance rm27v100 of ShiversRoom
	(properties
		picture 27100
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 5)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27110
	)

	(method (init)
		(self createPoly: 76 142 110 23 159 23 205 141 77 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27103
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27101
	)
)

