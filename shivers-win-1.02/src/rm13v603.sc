;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13603)
(include sci.sh)
(use Main)

(public
	rm13v603 0
)

(instance rm13v603 of ShiversRoom
	(properties
		picture 13221
	)

	(method (init)
		(efExitForward init: 9)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13018
	)

	(method (init)
		(self createPoly: 148 98 115 95 115 48 146 45)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13437
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13436
	)
)

