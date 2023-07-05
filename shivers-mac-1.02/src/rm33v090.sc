;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33090)
(include sci.sh)
(use Main)

(public
	rm33v090 0
)

(instance rm33v090 of ShiversRoom
	(properties
		picture 33090
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
		nextRoom 33100
	)

	(method (init)
		(self createPoly: 70 13 70 142 183 142 183 12 70 12)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33300
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33200
	)
)

