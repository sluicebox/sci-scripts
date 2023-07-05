;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 976)
(include sci.sh)
(use Motion)

(class Wander of Motion
	(properties
		distance 30
	)

	(method (init param1 param2)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= distance param2)
			)
		)
		(self setTarget:)
		(super init: client)
	)

	(method (setTarget &tmp temp0)
		(= x (+ (client x:) (- distance (Random 0 (= temp0 (* distance 2))))))
		(= y (+ (client y:) (- distance (Random 0 temp0))))
	)

	(method (onTarget)
		(return 0)
	)

	(method (doit)
		(super doit:)
		(if (client isStopped:)
			(self moveDone:)
		)
	)

	(method (moveDone)
		(self init:)
	)
)

(class Chase of Motion
	(properties
		who 0
		distance 0
	)

	(method (init param1 param2 param3 param4)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= who param2)
				(if (>= argc 3)
					(= distance param3)
					(if (>= argc 4)
						(= caller param4)
					)
				)
			)
		)
		(super init: client (who x:) (who y:) caller)
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

	(method (doit)
		(if (<= (client distanceTo: who) distance)
			(self moveDone:)
		else
			(super doit:)
			(if (== b-moveCnt 0)
				(super init: client (who x:) (who y:) caller)
			)
		)
	)
)

