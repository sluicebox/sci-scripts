;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1503)
(include sci.sh)
(use Main)

(public
	rm1v503 0
)

(instance rm1v503 of ShiversRoom
	(properties
		picture 1503
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
		nextRoom 1501
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1500
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1510
	)

	(method (init)
		(self createPoly: 21 141 82 73 93 73 95 22 170 24 182 73 248 142)
		(super init: &rest)
	)
)

