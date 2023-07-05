;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1340)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v340 0
)

(instance rm1v340 of ShiversRoom
	(properties
		picture 1340
	)

	(method (init)
		(proc951_16 80)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1343
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1342
	)
)

