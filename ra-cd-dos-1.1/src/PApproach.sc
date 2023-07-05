;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 919)
(include sci.sh)
(use PolyPath)

(class PApproach of PolyPath
	(properties
		distance 20
		targetX 0
		targetY 0
	)

	(method (init param1 param2)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(if (IsObject [param2 0])
					(= targetX ([param2 0] x:))
					(= targetY ([param2 0] y:))
					(if (>= argc 3)
						(= distance [param2 1])
						(if (>= argc 4)
							(= caller [param2 2])
						)
					)
				else
					(= targetX [param2 0])
					(= targetY [param2 1])
					(if (>= argc 4)
						(= distance [param2 2])
						(if (>= argc 5)
							(= caller [param2 3])
						)
					)
				)
			)
			(super init: client targetX targetY caller)
		else
			(super init:)
		)
	)

	(method (onTarget)
		(return
			(<= (GetDistance (client x:) (client y:) targetX targetY) distance)
		)
	)
)

