;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use System)

(public
	scuffReg 0
)

(local
	local0
)

(instance scuffReg of Rgn
	(properties)

	(method (init)
		(super init:)
		(if (or (< gPrevRoomNum 31) (and (< gPrevRoomNum 41) (> gCurRoomNum 41)))
			(= local0 1)
		)
		(self setScript: scuffing)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance scuffing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(= cycles 1)
					(= local0 0)
				else
					(= seconds (Random 18 25))
				)
			)
			(1
				(= cycles 1)
			)
			(2
				(if (!= [gCycleTimers 0] 1)
					(cond
						((< gCurRoomNum 40)
							(Print 401 0) ; "You hear scuffling upstairs."
						)
						((< gCurRoomNum 74)
							(Print 401 1) ; "You hear scuffling further upstairs."
						)
					)
				)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

