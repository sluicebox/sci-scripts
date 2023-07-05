;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64961)
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
		(self doit:)
	)

	(method (dispose)
		(if (== (client view:) vStopped)
			(client view: vWalking)
		)
		(super dispose:)
	)

	(method (doit &tmp curLoop theMover)
		(if (client isStopped:)
			(cond
				(
					(and
						(== vStopped -1)
						(!= (client loop:) (- (NumLoops client) 1))
					)
					(= curLoop (client loop:))
					(client loop: (- (NumLoops client) 1) setCel: 0)
				)
				((and (!= vStopped -1) (== (client view:) vWalking))
					(client setCel: 0 view: vStopped)
					(= theMover (client mover:))
				)
				((!= vStopped -1)
					(super doit:)
				)
			)
		else
			(= clientLastCel (client lastCel:))
			(switch vStopped
				((client view:)
					(client view: vWalking)
				)
				(-1
					(client setLoop: -1 setCel: 0)
					(if (== (client loop:) (- (NumLoops client) 1))
						(client loop: (client cel:) setCel: 0)
					)
				)
			)
			(super doit:)
		)
	)
)

