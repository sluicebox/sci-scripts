;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3444)
(include sci.sh)
(use Main)
(use nExit)
(use ExitFeature)
(use P2Fidget)

(public
	undergroundHallway5 0
)

(local
	[local0 4] = [199 44 415 250]
)

(instance undergroundHallway5 of P2Room
	(properties
		picture 751
		south 3454
	)

	(method (init)
		(super init: &rest)
		(doorF init: [local0 0] [local0 1] [local0 2] [local0 3])
		(curtis init:)
		(gGame handsOn: 1)
	)
)

(instance doorF of ExitFeature
	(properties
		nextRoom 3460
		exitScene 6341
	)
)

(instance curtis of P2Fidget
	(properties
		x 192
		y 335
		view 17510
		initStart 1
		initFinish 2
		cycleStart 2
		cycleFinish 5
	)
)

