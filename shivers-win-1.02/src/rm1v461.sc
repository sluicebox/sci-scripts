;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1461)
(include sci.sh)
(use Main)

(public
	rm1v461 0
)

(instance rm1v461 of ShiversRoom
	(properties
		picture 1461
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1460
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1460
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1451
	)

	(method (init)
		(self createPoly: 1 142 1 128 88 82 80 34 193 34 182 84 264 118 264 142)
		(super init: &rest)
	)
)

