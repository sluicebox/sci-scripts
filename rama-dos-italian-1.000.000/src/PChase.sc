;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64930)
(include sci.sh)
(use Main)
(use PolyPath)

(class PChase of PolyPath
	(properties
		distance 0
		who 0
		targetX 0
		targetY 0
	)

	(method (init actor whom howClose whoCares theObst)
		(if argc
			(cond
				((>= argc 5)
					(= obstacles theObst)
				)
				((not obstacles)
					(= obstacles (gCurRoom obstacles:))
				)
			)
			(if (>= argc 1)
				(= client actor)
				(if (>= argc 2)
					(= who whom)
					(= targetX (who x:))
					(= targetY (who y:))
					(if (>= argc 3)
						(= distance howClose)
						(if (>= argc 4)
							(= caller whoCares)
						)
					)
				)
			)
			(super init: client targetX targetY caller 1 obstacles)
		else
			(super init:)
		)
	)

	(method (doit &tmp theDistance)
		(cond
			((> (GetDistance targetX targetY (who x:) (who y:)) distance)
				(if points
					(points dispose:)
				)
				(= points 0)
				(= value 2)
				(self init: client who)
			)
			((<= (= theDistance (client distanceTo: who)) distance)
				(self moveDone:)
			)
			(else
				(super doit:)
			)
		)
	)

	(method (moveDone &tmp theDistance)
		(cond
			((<= (= theDistance (client distanceTo: who)) distance)
				(super moveDone:)
			)
			((== (points at: value) 30583)
				(if points
					(points dispose:)
				)
				(= points 0)
				(= value 2)
				(self init: client who)
			)
			(else
				(self setTarget: init:)
			)
		)
	)
)

