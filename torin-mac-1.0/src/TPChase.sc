;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64027)
(include sci.sh)
(use TPPolyPath)

(class TPChase of TPPolyPath
	(properties
		who 0
		distance 15
	)

	(method (setDefault)
		(super setDefault:)
		(= who 0)
		(= distance 15)
	)

	(method (newTarget)
		(= finalX (who x:))
		(= finalY (who y:))
	)

	(method (setArgs actor)
		(if (>= argc 2)
			(= who [actor 1])
			(if (>= argc 3)
				(= distance [actor 2])
				(if (>= argc 3)
					(= caller [actor 3])
				)
			)
		)
	)

	(method (onTarget)
		(return (<= (client distanceTo: who) distance))
	)
)

