;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 974)
(include sci.sh)
(use Motion)

(class Follow of Motion
	(properties
		who 0
		distance 20
	)

	(method (init param1 param2 param3)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= who param2)
				(if (>= argc 3)
					(= distance param3)
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

	(method (doit &tmp temp0)
		(if (> (client distanceTo: who) distance)
			(super doit:)
			(if (== b-moveCnt 0)
				(super init: client (who x:) (who y:))
			)
		else
			(= temp0 (GetAngle (client x:) (client y:) (who x:) (who y:)))
			(if (client looper:)
				((client looper:) doit: client temp0)
			else
				(DirLoop client temp0)
			)
		)
	)

	(method (moveDone))
)

