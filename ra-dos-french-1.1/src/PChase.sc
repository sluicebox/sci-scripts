;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 930)
(include sci.sh)
(use Main)
(use PolyPath)
(use System)

(class PChase of PolyPath
	(properties
		who 0
		distance 0
		targetX 0
		targetY 0
	)

	(method (init actor whom howClose whoCares theObst)
		(cond
			((>= argc 5)
				(= obstacles theObst)
			)
			((not (IsObject obstacles))
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
	)

	(method (doit &tmp theDistance)
		(cond
			((> (GetDistance targetX targetY (who x:) (who y:)) distance)
				(if points
					(Memory memFREE points)
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
			((== (WordAt points value) 30583)
				(if points
					(Memory memFREE points)
				)
				(= points 0)
				(= value 2)
				(self init: client who)
			)
			(else
				(self init:)
			)
		)
	)
)

(class PFollow of PolyPath
	(properties
		who 0
		distance 0
		targetX 0
		targetY 0
	)

	(method (init actor whom howClose theObst &tmp obstList)
		(= obstList
			(if (>= argc 4)
				theObst
			else
				(gCurRoom obstacles:)
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
				)
			)
		)
		(super init: client targetX targetY 0 1 obstList)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((> (GetDistance targetX targetY (who x:) (who y:)) distance)
				(if points
					(Memory memFREE points)
				)
				(= points 0)
				(= value 2)
				(self init: client who)
				0
			)
			((<= (= temp0 (client distanceTo: who)) distance)
				(= temp1 (GetAngle (client x:) (client y:) (who x:) (who y:)))
				(if (!= (client heading:) temp1)
					(client setHeading: temp1)
				)
				(= xLast (client x:))
				(= yLast (client y:))
				(= b-moveCnt gGameTime)
				0
			)
			(else
				(super doit:)
			)
		)
	)

	(method (moveDone)
		(self init:)
	)
)

