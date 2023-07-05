;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 970)
(include sci.sh)
(use Motion)

(class Wander of Motion
	(properties
		distance 30
	)

	(method (init theObj dist &tmp temp0)
		(if (>= argc 1)
			(= client theObj)
			(if (>= argc 2)
				(= distance dist)
			)
		)
		(= temp0 (* distance 2))
		(= x (+ (theObj x:) (- distance (Random 0 temp0))))
		(= y (+ (theObj y:) (- distance (Random 0 temp0))))
		(super init: client x y)
	)

	(method (setTarget &tmp diam)
		(= diam (* distance 2))
		(= x (+ (client x:) (- distance (Random 0 diam))))
		(= y (+ (client y:) (- distance (Random 0 diam))))
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

