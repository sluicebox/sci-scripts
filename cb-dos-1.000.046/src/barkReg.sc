;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Game)
(use System)

(public
	barkReg 0
)

(instance barkReg of Rgn
	(properties)

	(method (init)
		(super init:)
		(self setScript: barking)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance barking of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds (Random 18 30))
			)
			(1
				(= cycles 1)
			)
			(2
				(if (!= gCurRoomNum 16)
					(if (== gCurRoomNum 23)
						(= temp0 (Sound pause: 1))
					)
					(Print 400 0) ; "Is that Beauregard barking?"
					(if (== gCurRoomNum 23)
						(Sound pause: temp0)
					)
				)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

