;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Motion)
(use System)

(class ArrayPath of MoveTo
	(properties
		value 0
		thePoints 0
	)

	(method (init param1 param2 param3 param4)
		(if (>= argc 1)
			(= client param1)
			(= thePoints param2)
			(if (>= argc 2)
				(= value param3)
				(if (>= argc 3)
					(= caller param4)
				)
			)
		)
		(if argc
			(self setTarget:)
		)
		(super init:)
	)

	(method (setTarget)
		(if (!= (WordAt thePoints value) -32768)
			(= x (WordAt thePoints value))
			(= y (WordAt thePoints (++ value)))
			(++ value)
		)
	)

	(method (onTarget)
		(return (and (== (client x:) x) (== (client y:) y)))
	)

	(method (moveDone)
		(if (== (WordAt thePoints value) -32768)
			(super moveDone:)
		else
			(self setTarget: init:)
		)
	)
)

