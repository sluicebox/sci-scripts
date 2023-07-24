;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8530)
(include sci.sh)
(use Main)
(use n951)

(public
	rm8v530 0
)

(instance rm8v530 of ShiversRoom
	(properties
		picture 8530
	)

	(method (init)
		(proc951_16 94)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 8520
	)

	(method (init)
		(self
			createPoly: 0 1 0 142 262 142 262 0 0 0 54 18 47 104 226 104 218 17 52 17
		)
		(super init: &rest)
	)
)

