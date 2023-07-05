;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3145)
(include sci.sh)
(use Main)
(use nExit)

(public
	networkRoomCH5SR4 0
)

(instance networkRoomCH5SR4 of P2Room
	(properties
		picture 161
		south 3135
	)

	(method (init)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

