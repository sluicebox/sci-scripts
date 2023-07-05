;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use GK2Room)
(use System)

(public
	restoreRm 0
)

(instance restoreRm of GK2Room
	(properties)

	(method (init)
		(super init: &rest)
		(gCurRoom setScript: restoreScript)
	)
)

(instance restoreScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGame restore:)
				(= cycles 12)
			)
			(2
				(gCurRoom newRoom: 34) ; demoRm
				(self dispose:)
			)
		)
	)
)

