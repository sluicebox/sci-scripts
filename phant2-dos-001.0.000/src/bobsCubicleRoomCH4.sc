;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4304)
(include sci.sh)
(use Main)
(use nExit)

(public
	bobsCubicleRoomCH4 0
)

(instance bobsCubicleRoomCH4 of P2Room
	(properties
		picture 262
		south 3344
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

