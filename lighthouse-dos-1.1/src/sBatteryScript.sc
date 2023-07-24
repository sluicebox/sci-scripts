;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use System)

(public
	sBatteryScript 0
)

(instance sBatteryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(SetFlag 343)
				(self init:)
			)
		)
	)
)

