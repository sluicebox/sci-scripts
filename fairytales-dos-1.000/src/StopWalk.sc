;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 961)
(include sci.sh)
(use PChase)
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
		(super dispose:)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= temp2 (client loop:))
		(= temp3 (- (NumLoops client) 1))
		(if (client isStopped:)
			(if (!= temp2 temp3)
				(client loop: temp3 cel: temp2)
				(if
					(and
						(= temp1 (client mover:))
						(not (temp1 completed:))
						(not (temp1 isKindOf: PFollow))
					)
					(client setMotion: 0)
				)
			)
		else
			(if (== temp2 temp3)
				(client loop: (client cel:) cel: 0)
			)
			(super doit:)
		)
	)
)

