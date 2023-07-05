;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27130)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v130 0
)

(instance rm27v130 of ShiversRoom
	(properties
		picture 27130
	)

	(method (init)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 5)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27140
	)

	(method (init)
		(self createPoly: 60 142 95 82 93 34 184 35 184 82 218 141 60 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27131
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27131
	)
)

