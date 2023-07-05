;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20340)
(include sci.sh)
(use Main)
(use n951)

(public
	rm20v340 0
)

(instance rm20v340 of ShiversRoom
	(properties
		picture 20340
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 0)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20360
	)

	(method (init)
		(self createPoly: 87 19 87 130 174 130 174 20 88 19)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20330
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20330
	)
)

