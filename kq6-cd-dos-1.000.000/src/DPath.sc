;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 964)
(include sci.sh)
(use Motion)
(use System)

(class DPath of Motion
	(properties
		points 0
		value 0
	)

	(method (init theClient thePoints &tmp i)
		(= points (or points (List new:)))
		(if argc
			(= client theClient)
			(for ((= i 0)) (<= i (- argc 3)) ((++ i))
				(points add: [thePoints i] [thePoints (++ i)])
			)
			(if (<= i (- argc 2))
				(= caller [thePoints i])
			)
		)
		(or (points contains: -32768) (points add: -32768))
		(self setTarget:)
		(super init:)
		(if (not argc)
			(self doit:)
		)
	)

	(method (dispose)
		(if (IsObject points)
			(points dispose:)
		)
		(super dispose:)
	)

	(method (setTarget)
		(if (!= (points at: value) -32768)
			(= x (points at: value))
			(= y (points at: (++ value)))
			(++ value)
		)
	)

	(method (moveDone)
		(if (== (points at: value) -32768)
			(super moveDone:)
		else
			(self init:)
		)
	)
)

