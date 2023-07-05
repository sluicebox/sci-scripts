;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 331)
(include sci.sh)
(use Main)
(use ADRoom)

(public
	rm331 0
)

(instance rm331 of ADRoom
	(properties)

	(method (init)
		(super init: &rest)
		(gCurRoom newRoom: gPrevRoomNum)
	)
)

