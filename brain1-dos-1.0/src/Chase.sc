;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 972)
(include sci.sh)
(use Motion)

(class Chase of Motion
	(properties
		who 0
		distance 0
	)

	(method (init actor whom howClose whoCares)
		(if (>= argc 1)
			(= client actor)
			(if (>= argc 2)
				(= who whom)
				(if (>= argc 3)
					(= distance howClose)
					(if (>= argc 4)
						(= caller whoCares)
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
		(if (self onTarget:)
			(self moveDone:)
		else
			(super doit:)
			(if (== b-moveCnt 0)
				(super init: client (who x:) (who y:) caller)
			)
		)
	)
)

