;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3454)
(include sci.sh)
(use Main)
(use nExit)
(use P2Feature)

(public
	undergroundHallway6 0
)

(local
	[local0 4] = [257 77 381 200]
)

(instance undergroundHallway6 of P2Room
	(properties
		picture 760
		south 3434
	)

	(method (init)
		(super init: &rest)
		(doorF init: [local0 0] [local0 1] [local0 2] [local0 3])
		(gGame handsOn: 1)
	)
)

(instance doorF of P2Feature
	(properties
		scene 6342
		nextRoom 3425
	)
)

