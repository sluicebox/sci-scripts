;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27231)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v231 0
)

(instance rm27v231 of ShiversRoom
	(properties
		picture 27231
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
		nextRoom 27240
	)

	(method (init)
		(self createPoly: 88 142 119 55 143 55 176 142 88 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27230
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27232
	)
)

