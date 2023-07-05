;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27131)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v131 0
)

(instance rm27v131 of ShiversRoom
	(properties
		picture 27131
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
		nextRoom 27122
	)

	(method (init)
		(self createPoly: 37 141 65 111 109 65 149 65 208 140 37 141)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27130
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27130
	)
)

