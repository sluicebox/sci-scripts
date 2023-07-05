;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 404)
(include sci.sh)
(use Main)
(use PolyPath)
(use System)

(class MChase of PolyPath
	(properties
		who 0
		distance 0
		targetX 0
		targetY 0
		doitSkips 10
	)

	(method (init param1 param2 param3 param4 param5 &tmp [temp0 20])
		(if argc
			(cond
				((>= argc 5)
					(= obstacles param5)
				)
				((not (IsObject obstacles))
					(= obstacles (gCurRoom obstacles:))
				)
			)
			(if (>= argc 1)
				(= client param1)
				(if (>= argc 2)
					(= who param2)
					(= targetX (who x:))
					(= targetY (who y:))
					(if (>= argc 3)
						(= distance param3)
						(if (>= argc 4)
							(= caller param4)
						)
					)
				)
			)
			(super init: client targetX targetY caller 1 obstacles)
		)
	)

	(method (doit)
		(cond
			((>= (GetDistance targetX targetY (who x:) (who y:)) distance)
				(if (not doitSkips)
					(= doitSkips 10)
					(if points
						(Memory memFREE points)
					)
					(= points 0)
					(= value 2)
					(self init: client who)
				else
					(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
						(= b-moveCnt gGameTime)
						(DoBresen self)
					)
					(-- doitSkips)
				)
			)
			(
				(<=
					(= global461
						(GetDistance (client x:) (client y:) (who x:) (who y:))
					)
					distance
				)
				(self moveDone:)
			)
			(
				(>=
					(= global461
						(GetDistance (client x:) (client y:) (who x:) (who y:))
					)
					global462
				)
				(self moveDone:)
			)
			((>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
				(= b-moveCnt gGameTime)
				(DoBresen self)
			)
		)
	)

	(method (moveDone &tmp temp0)
		(cond
			((or (<= global461 distance) (> global461 global462))
				(client cue:)
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
				(self init: client)
			)
		)
	)
)

