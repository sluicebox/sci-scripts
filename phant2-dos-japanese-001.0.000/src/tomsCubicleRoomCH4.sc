;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4504)
(include sci.sh)
(use Main)
(use nExit)

(public
	tomsCubicleRoomCH4 0
)

(instance tomsCubicleRoomCH4 of P2Room
	(properties
		picture 282
		south 3354
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

