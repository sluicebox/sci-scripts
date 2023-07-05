;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Motion)

(public
	PStopWalk 0
)

(class PStopWalk of Fwd
	(properties
		vWalking 0
		shouldCycle 0
	)

	(method (init param1 param2)
		(if argc
			(= vWalking ((= client param1) view:))
			(if (>= argc 2)
				(= shouldCycle param2)
			)
		)
		(super init: client)
		(self doit:)
	)

	(method (doit)
		(if (client isStopped:)
			(cond
				((== (client loop:) 0)
					(super doit:)
					(client loop: 1 cel: 0)
				)
				(shouldCycle
					(super doit:)
				)
			)
		else
			(if (== (client loop:) 1)
				(client loop: 0 cel: 0)
			)
			(super doit:)
		)
	)
)

