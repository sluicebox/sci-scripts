;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3424)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)

(public
	undergroundHallway2 0
)

(local
	[local0 4] = [313 217 333 310]
)

(instance undergroundHallway2 of P2Room
	(properties
		picture 740
		south 3414
		west 3414
	)

	(method (init)
		(super init: &rest)
		(sensorF init: [local0 0] [local0 1] [local0 2] [local0 3])
		(gGame handsOn: 1)
	)
)

(instance sensorF of ExitFeature
	(properties
		nextRoom 3044
		exitScene 6343
	)

	(method (init)
		(super init: &rest)
		(if (== gChapter 5)
			(= nextRoom 3045)
		)
	)
)

