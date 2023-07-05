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

