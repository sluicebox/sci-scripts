;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3123)
(include sci.sh)
(use Main)
(use nExit)
(use P2View)

(public
	networkRoomCH3SR2 0
)

(local
	[local0 2] = [168 238]
	[local2 2] = [105 298]
)

(instance networkRoomCH3SR2 of CloseupRoom
	(properties
		picture 140
		exitRoom 3113
	)

	(method (init)
		(monitorV init: [local0 0] [local0 1] delVerb: 4)
		(hammerV init: [local2 0] [local2 1])
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance monitorV of P2View
	(properties
		view 140
	)
)

(instance hammerV of P2View
	(properties
		view 140
		loop 1
		doneFlag 316
		invItem 14
	)
)

