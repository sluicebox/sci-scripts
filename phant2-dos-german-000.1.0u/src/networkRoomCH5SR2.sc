;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3125)
(include sci.sh)
(use Main)
(use nExit)
(use P2View)

(public
	networkRoomCH5SR2 0
)

(local
	[local0 2] = [168 238]
)

(instance networkRoomCH5SR2 of CloseupRoom
	(properties
		picture 140
		exitRoom 3115
	)

	(method (init)
		(monitorV init: [local0 0] [local0 1] delVerb: 4 isHot: 0)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

(instance monitorV of P2View
	(properties
		view 140
	)
)

