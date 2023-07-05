;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16530)
(include sci.sh)
(use Main)

(public
	rm16v530 0
)

(instance rm16v530 of ShiversRoom
	(properties
		picture 16530
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16700
	)

	(method (init)
		(self createPoly: 0 61 30 55 30 0 0 0 0 142 33 142 0 113 0 61)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16240
	)

	(method (init)
		(self createPoly: 36 142 1 113 1 66 27 62 31 103 232 141 36 143)
		(super init: &rest)
	)
)

