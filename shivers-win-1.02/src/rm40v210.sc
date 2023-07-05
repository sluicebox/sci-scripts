;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40210)
(include sci.sh)
(use Main)

(public
	rm40v210 0
)

(instance rm40v210 of ShiversRoom
	(properties
		picture 40070
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40190
	)

	(method (init)
		(self createPoly: 218 127 227 1 155 0 125 105 63 115 34 127 218 127)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 40200
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 40200
	)
)

