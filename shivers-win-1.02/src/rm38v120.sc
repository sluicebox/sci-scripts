;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38120)
(include sci.sh)
(use Main)
(use n951)

(public
	rm38v120 0
)

(instance rm38v120 of ShiversRoom
	(properties
		picture 38120
	)

	(method (init)
		(if (IsFlag 6)
			(ClearFlag 6)
			(gSounds play: 10405 0 50 0)
		)
		(efExitBack init: 8)
		(efExitForward init: 3)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 38100
	)

	(method (init)
		(self
			createPoly:
				0
				1
				0
				137
				263
				138
				264
				0
				0
				0
				47
				67
				47
				131
				214
				131
				214
				68
				48
				67
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 6020
	)

	(method (init)
		(self createPoly: 58 85 210 85 208 127 61 127 58 86)
		(super init: &rest)
	)
)

