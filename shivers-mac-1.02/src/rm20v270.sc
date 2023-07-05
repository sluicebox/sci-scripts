;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20270)
(include sci.sh)
(use Main)

(public
	rm20v270 0
)

(instance rm20v270 of ShiversRoom
	(properties
		picture 20270
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRightHigh init: 1)
		(efExitLeftHigh init: 2)
		(efExitLeftLow init: 2)
		(efExitRightLow init: 1)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20200
	)

	(method (init)
		(self
			createPoly:
				84
				94
				85
				144
				179
				144
				178
				94
				178
				26
				161
				1
				104
				1
				86
				19
				84
				94
		)
		(super init: &rest)
	)
)

(instance efExitRightHigh of ExitFeature
	(properties
		nextRoom 20280
	)

	(method (init)
		(self createPoly: 240 0 262 0 262 75 240 75 240 0)
		(super init: &rest)
	)
)

(instance efExitLeftHigh of ExitFeature
	(properties
		nextRoom 20300
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 75 0 75 0 0)
		(super init: &rest)
	)
)

(instance efExitLeftLow of ExitFeature
	(properties
		nextRoom 20750
	)

	(method (init)
		(self createPoly: 0 75 20 75 20 143 0 143 0 75)
		(super init: &rest)
	)
)

(instance efExitRightLow of ExitFeature
	(properties
		nextRoom 20730
	)

	(method (init)
		(self createPoly: 240 75 262 75 262 143 240 143 240 75)
		(super init: &rest)
	)
)

