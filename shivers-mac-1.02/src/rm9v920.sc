;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9920)
(include sci.sh)
(use Main)

(public
	rm9v920 0
)

(instance rm9v920 of ShiversRoom
	(properties
		picture 9920
	)

	(method (init)
		(efExitDown init: 5)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 9510
	)

	(method (init)
		(self createPoly: 0 100 263 100 263 143 0 143)
		(super init: &rest)
	)
)

