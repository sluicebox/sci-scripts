;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10350)
(include sci.sh)
(use Main)

(public
	rm10v350 0
)

(instance rm10v350 of ShiversRoom
	(properties
		picture 10350
	)

	(method (init)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10340
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10360
	)

	(method (init)
		(self createPoly: 38 105 67 0 189 0 218 105)
		(super init: &rest)
	)
)

