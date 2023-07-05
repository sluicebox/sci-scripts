;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22110)
(include sci.sh)
(use Main)

(public
	rm22v110 0
)

(instance rm22v110 of ShiversRoom
	(properties
		picture 22110
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22310
	)

	(method (init)
		(self createPoly: 98 47 85 141 186 141 198 39 101 37 99 47)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22120
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22100
	)
)

