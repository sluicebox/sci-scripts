;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 979)
(include sci.sh)
(use Motion)

(class Wander of Motion
	(properties
		distance 30
	)

	(method (init param1 param2 &tmp temp0)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= distance param2)
			)
		)
		(= temp0 (* distance 2))
		(= x (+ (param1 x:) (- distance (Random 0 temp0))))
		(= y (+ (param1 y:) (- distance (Random 0 temp0))))
		(super init: client x y)
	)

	(method (setTarget &tmp temp0)
		(= temp0 (* distance 2))
		(= x (+ (client x:) (- distance (Random 0 temp0))))
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
		(self init: client distance)
	)
)

