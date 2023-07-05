;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27201)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v201 0
)

(instance rm27v201 of ShiversRoom
	(properties
		picture 27201
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 5)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27190
	)

	(method (init)
		(self createPoly: 71 143 88 42 135 42 158 142 71 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27200
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27200
	)
)

