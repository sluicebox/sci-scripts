;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class FidgetScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gGame detailLevel:) 5)
					(= ticks (Random 120 600))
				else
					(= state -1)
				)
			)
			(1
				(client
					cel: 0
					setLoop: (Random 0 (NumLoops client))
					setCycle: End self
				)
			)
			(2
				(client cel: 0 show:)
				(= cycles 2)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

