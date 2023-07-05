;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37181)
(include sci.sh)
(use Main)

(public
	rm37v181 0
)

(instance rm37v181 of ShiversRoom
	(properties
		picture 37181
	)

	(method (init)
		(efExitClock init: 0)
		(efExitBack1 init: 8)
		(efExitBack2 init: 8)
		(super init: &rest)
	)
)

(instance efExitClock of ExitFeature
	(properties
		nextRoom 37182
	)

	(method (init)
		(self createPoly: 88 20 88 134 175 134 175 17 88 17)
		(super init: &rest)
	)
)

(instance efExitBack1 of ExitFeature
	(properties
		nextRoom 37180
	)

	(method (init)
		(self createPoly: 1 0 1 141 53 141 54 1 1 0)
		(super init: &rest)
	)
)

(instance efExitBack2 of ExitFeature
	(properties
		nextRoom 37180
	)

	(method (init)
		(self createPoly: 195 0 195 141 262 141 262 0 195 0)
		(super init: &rest)
	)
)

