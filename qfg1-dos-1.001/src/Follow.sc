;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 971)
(include sci.sh)
(use Motion)

(class Follow of Motion
	(properties
		who 0
		distance 20
	)

	(method (init theObj whom dist)
		(if (>= argc 1)
			(= client theObj)
			(if (>= argc 2)
				(= who whom)
				(if (>= argc 3)
					(= distance dist)
				)
			)
		)
		(if (> (client distanceTo: who) distance)
			(super init: client (who x:) (who y:))
		)
	)

	(method (onTarget)
		(return (<= (client distanceTo: who) distance))
	)

	(method (setTarget)
		(cond
			(argc
				(super setTarget: &rest)
			)
			((not (self onTarget:))
				(super setTarget: (who x:) (who y:))
			)
		)
	)

	(method (doit &tmp angle)
		(if (> (client distanceTo: who) distance)
			(super doit:)
			(if (== b-moveCnt 0)
				(super init: client (who x:) (who y:))
			)
		else
			(= angle (GetAngle (client x:) (client y:) (who x:) (who y:)))
			(if (client looper:)
				((client looper:) doit: client angle)
			else
				(DirLoop client angle)
			)
		)
	)

	(method (moveDone))
)

