;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33280)
(include sci.sh)
(use Main)

(public
	rm33v280 0
)

(instance rm33v280 of ShiversRoom
	(properties
		picture 33280
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
		nextRoom 27124
	)

	(method (init)
		(self createPoly: 59 143 81 126 81 25 191 25 191 127 211 142 61 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 33020
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 33020
	)
)

