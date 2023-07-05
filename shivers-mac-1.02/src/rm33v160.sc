;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33160)
(include sci.sh)
(use Main)

(public
	rm33v160 0
)

(instance rm33v160 of ShiversRoom
	(properties
		picture 33160
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33170
	)

	(method (init)
		(self createPoly: 76 13 51 3 51 142 184 142 184 13 76 13)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33150
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33140
	)
)

