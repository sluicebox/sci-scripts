;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64964)
(include sci.sh)
(use Array)
(use Motion)

(class DPath of Motion
	(properties
		points 0
		value 0
	)

	(method (init theClient thePoints &tmp i j)
		(if (not points)
			(= points (IntArray newWith: (- argc 1) 32768))
		)
		(if argc
			(= client theClient)
			(= j (- (points indexOf: 32768) 1))
			(for ((= i 0)) (<= i (- argc 3)) ((++ i))
				(points at: (++ j) [thePoints i])
				(points at: (++ j) [thePoints (++ i)])
			)
			(if (<= i (- argc 2))
				(= caller [thePoints i])
			)
		)
		(points at: (++ j) 32768)
		(self setTarget:)
		(super init:)
		(if (not argc)
			(self doit:)
		)
	)

	(method (dispose)
		(if points
			(points dispose:)
		)
		(super dispose:)
	)

	(method (setTarget)
		(if (!= (points at: value) 32768)
			(= x (points at: value))
			(= y (points at: (++ value)))
			(++ value)
		)
	)

	(method (moveDone)
		(if (== (points at: value) 32768)
			(super moveDone:)
		else
			(self init:)
		)
	)
)

