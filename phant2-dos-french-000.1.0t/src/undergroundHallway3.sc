;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3425)
(include sci.sh)
(use Main)
(use nExit)
(use P2Feature)

(public
	undergroundHallway3 0
)

(local
	[local0 4] = [219 48 244 233]
)

(instance undergroundHallway3 of P2Room
	(properties
		picture 731
		south 3414
	)

	(method (init)
		(super init: &rest)
		(elvdoorF init: [local0 0] [local0 1] [local0 2] [local0 3])
		(gGame handsOn: 1)
	)
)

(instance elvdoorF of P2Feature
	(properties
		nextRoom 3424
	)
)

