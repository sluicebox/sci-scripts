;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7120)
(include sci.sh)
(use Main)

(public
	rm7v120 0
)

(instance rm7v120 of ShiversRoom
	(properties
		picture 7120
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7410
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7400
	)

	(method (init)
		(self createPoly: 90 27 90 99 10 142 206 142 182 114 228 113 227 23)
		(super init: &rest)
	)
)

