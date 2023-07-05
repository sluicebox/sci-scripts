;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 970)
(include sci.sh)
(use Motion)

(class Wander of Motion
	(properties
		distance 30
	)

	(method (init theObj dist)
		(if (>= argc 1)
			(= client theObj)
			(if (>= argc 2)
				(= distance dist)
			)
		)
		(self setTarget:)
		(super init: client)
	)

	(method (setTarget &tmp diam)
		(= x (+ (client x:) (- distance (Random 0 (= diam (* distance 2))))))
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
		(self init:)
	)
)

