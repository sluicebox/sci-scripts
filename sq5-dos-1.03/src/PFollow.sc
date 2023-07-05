;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 932)
(include sci.sh)
(use Main)
(use PolyPath)

(class PFollow of PolyPath
	(properties
		who 0
		distance 0
		targetX 0
		targetY 0
	)

	(method (init actor whom howClose theObst &tmp obstList)
		(if argc
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
		else
			(super init:)
		)
	)

	(method (doit &tmp theDistance angle)
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
			((<= (= theDistance (client distanceTo: who)) distance)
				(= angle (GetAngle (client x:) (client y:) (who x:) (who y:)))
				(if (!= (client heading:) angle)
					(client setHeading: angle)
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
		(self setTarget: init:)
	)
)

