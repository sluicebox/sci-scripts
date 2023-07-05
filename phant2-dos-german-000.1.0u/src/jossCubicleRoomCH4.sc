;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4404)
(include sci.sh)
(use Main)
(use nExit)

(public
	jossCubicleRoomCH4 0
)

(instance jossCubicleRoomCH4 of P2Room
	(properties
		picture 271
		south 3354
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

