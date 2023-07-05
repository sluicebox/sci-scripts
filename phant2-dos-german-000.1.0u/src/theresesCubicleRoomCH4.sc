;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4204)
(include sci.sh)
(use Main)
(use nExit)

(public
	theresesCubicleRoomCH4 0
)

(instance theresesCubicleRoomCH4 of P2Room
	(properties
		picture 251
		south 3344
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

