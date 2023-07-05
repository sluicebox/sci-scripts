;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9080)
(include sci.sh)
(use Main)

(public
	rm9v08 0
)

(instance rm9v08 of ShiversRoom
	(properties
		picture 9080
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
		nextRoom 9110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9010
	)

	(method (init)
		(self createPoly: 155 103 155 34 199 34 198 107)
		(super init: &rest)
	)
)

