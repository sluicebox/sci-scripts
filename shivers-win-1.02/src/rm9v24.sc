;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9240)
(include sci.sh)
(use Main)

(public
	rm9v24 0
)

(instance rm9v24 of ShiversRoom
	(properties
		picture 9240
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
		nextRoom 9940
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9960
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9220
	)

	(method (init)
		(self createPoly: 82 93 82 41 139 42 140 86 166 140 65 141)
		(super init: &rest)
	)
)

