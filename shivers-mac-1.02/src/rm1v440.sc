;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1440)
(include sci.sh)
(use Main)

(public
	rm1v440 0
)

(instance rm1v440 of ShiversRoom
	(properties
		picture 1440
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1442
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1441
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1430
	)

	(method (init)
		(self createPoly: 13 140 59 78 84 78 84 54 171 54 171 78 187 78 224 141)
		(super init: &rest)
	)
)

