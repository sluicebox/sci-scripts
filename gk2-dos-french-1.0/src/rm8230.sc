;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8230)
(include sci.sh)
(use Main)
(use GK2Room)
(use System)

(public
	rm8230 0
)

(instance rm8230 of GK2Room
	(properties
		picture 8230
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

