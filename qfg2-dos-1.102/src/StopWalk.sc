;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 961)
(include sci.sh)
(use Motion)

(public
	StopWalk 0
)

(class StopWalk of Fwd
	(properties
		vWalking 0
		vStopped 0
	)

	(method (init who stopView)
		(if argc
			(= vWalking ((= client who) view:))
			(if (>= argc 2)
				(= vStopped stopView)
			)
		)
		(super init: client)
	)

	(method (dispose)
		(if (and (== (client view:) vStopped) (not (client isStopped:)))
			(client view: vWalking)
		)
		(super dispose:)
	)

	(method (doit &tmp [temp0 2])
		(if (client isStopped:)
			(if (== (client view:) vWalking)
				(client view: vStopped)
				(super doit:)
			)
		else
			(if (== (client view:) vStopped)
				(client view: vWalking)
			)
			(super doit:)
		)
	)
)

