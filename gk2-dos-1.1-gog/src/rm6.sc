;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use GK2Room)

(public
	rm6 0
)

(local
	local0
)

(instance rm6 of GK2Room
	(properties)

	(method (init)
		(UnLoad 130 gPrevRoomNum)
		(super init: &rest)
		(self newRoom: gPrevRoomNum)
	)
)

