;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20430)
(include sci.sh)
(use Main)

(public
	rm20v430 0
)

(instance rm20v430 of ShiversRoom
	(properties
		picture 20430
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20400
	)

	(method (init)
		(self createPoly: 107 42 107 116 227 142 240 43 108 42)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20440
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20470
	)
)

