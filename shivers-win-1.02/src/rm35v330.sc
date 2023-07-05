;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35330)
(include sci.sh)
(use Main)
(use n951)

(public
	rm35v330 0
)

(instance rm35v330 of ShiversRoom
	(properties
		picture 35330
	)

	(method (init)
		(if (IsFlag 29)
			(self picture: 35334)
		)
		(efExitDown init: 5)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35180
	)

	(method (init)
		(self createPoly: 93 49 93 105 213 110 213 49 94 49)
		(super init: &rest)
	)
)

(instance efExitDown of ExitFeature
	(properties
		nextRoom 35401
	)

	(method (init)
		(self
			createPoly:
				98
				143
				93
				125
				99
				111
				106
				111
				110
				127
				180
				125
				205
				143
				98
				143
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35310
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35300
	)
)

