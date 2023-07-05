;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33080)
(include sci.sh)
(use Main)

(public
	rm33v080 0
)

(instance rm33v080 of ShiversRoom
	(properties
		picture 33080
	)

	(method (init)
		(efExitForward init: 3)
		(efExitForwardLeft init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 33300
	)

	(method (init)
		(self createPoly: 80 5 80 135 187 135 187 5 80 5)
		(super init: &rest)
	)
)

(instance efExitForwardLeft of ExitFeature
	(properties
		nextRoom 33110
	)

	(method (init)
		(self createPoly: 36 0 70 0 70 142 36 142 36 1)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33210
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33210
	)
)

