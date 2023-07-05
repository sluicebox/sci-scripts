;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7005)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)

(public
	dreamingTreeRoomCH5 0
)

(instance dreamingTreeRoomCH5 of P2Room
	(properties
		picture 421
		south 900
	)

	(method (init)
		(SetFlag 1001)
		(gP2SongPlyr start: 910)
		(super init: &rest)
		(gGame handsOn: 1)
	)
)

