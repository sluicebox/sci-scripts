;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8131)
(include sci.sh)
(use Main)
(use GK2Room)
(use System)

(public
	rm8131 0
)

(instance rm8131 of GK2Room
	(properties
		picture 8131
	)

	(method (init)
		(super init: &rest)
		(self setScript: sInit)
	)
)

(instance sInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 10)
			)
			(1
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

