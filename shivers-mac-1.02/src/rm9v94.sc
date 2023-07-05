;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9940)
(include sci.sh)
(use Main)

(public
	rm9v94 0
)

(instance rm9v94 of ShiversRoom
	(properties
		picture 9940
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
		nextRoom 9250
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 9240
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 9280
	)

	(method (init)
		(self createPoly: 70 55 70 141 173 143 142 110 142 29 71 30)
		(super init: &rest)
	)
)

