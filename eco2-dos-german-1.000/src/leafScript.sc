;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 298)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	leafScript 0
)

(instance leafScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo
					view: 222
					cycleSpeed: 12
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gMessager say: 1 15 1 (if (== gCurRoomNum 200) 1 else 2) self 4)
			)
			(3
				(gCurrentRegionFlags set: 0)
				(gEgo normalize: 0 2)
				(gGame handsOn: points: 5)
				(self dispose:)
				(DisposeScript 298)
			)
		)
	)
)

