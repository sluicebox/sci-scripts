;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30360)
(include sci.sh)
(use Main)
(use n951)

(public
	rm30v360 0
)

(instance rm30v360 of ShiversRoom
	(properties
		picture 30360
	)

	(method (init)
		(if (IsFlag 85)
			(self picture: 30361)
		)
		(efExitForward init: 3)
		(efExitLeftLow init: 2)
		(efExitLeftHigh init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeftHigh of ExitFeature
	(properties
		nextRoom 30330
	)

	(method (init)
		(self createPoly: 0 43 20 47 20 0 0 0 0 43)
		(super init: &rest)
	)
)

(instance efExitLeftLow of ExitFeature
	(properties
		nextRoom 30330
	)

	(method (init)
		(self createPoly: 0 111 20 101 20 143 0 143 0 111)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 30350
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 30400
	)

	(method (init)
		(self createPoly: 171 49 22 49 0 45 0 109 22 99 22 132 171 132 171 49)
		(super init: &rest)
	)
)

