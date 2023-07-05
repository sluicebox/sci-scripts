;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27220)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v220 0
)

(instance rm27v220 of ShiversRoom
	(properties
		picture 27220
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
		nextRoom 27210
	)

	(method (init)
		(self createPoly: 71 142 110 54 136 54 184 142 71 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27221
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27221
	)
)

