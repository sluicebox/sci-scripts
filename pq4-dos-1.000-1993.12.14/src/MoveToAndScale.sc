;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Motion)

(class MoveToAndScale of MoveTo
	(properties
		slopeNum 0
		slopeDen 0
		const 0
	)

	(method (isMemberOf param1)
		(return
			(or
				(== param1 self)
				(and
					(& (param1 -info-:) $8000)
					(not (& -info- $8000))
					(== -propDict- (param1 -propDict-:))
				)
				(== param1 MoveTo)
			)
		)
	)

	(method (init param1 param2 param3 param4 param5)
		(if argc
			(= client param1)
			(client scaleSignal: (| (client scaleSignal:) $0001))
			(= slopeNum (- (client scaleX:) param4))
			(super init: param1 param2 param3 param5)
			(= slopeDen (GetDistance (client x:) (client y:) x y))
			(if (not slopeDen)
				(= slopeDen 1)
			)
			(= const param4)
		)
		(super init:)
	)

	(method (doit &tmp temp0 temp1)
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(if
				(<=
					(= temp1 (GetDistance x y (client x:) (client y:)))
					(client xStep:)
				)
				(= temp0 const)
			else
				(= temp0 (+ (/ (* slopeNum temp1) slopeDen) const))
			)
			(client scaleX: temp0 scaleY: temp0)
			(return (DoBresen self))
		else
			(return 0)
		)
	)

	(method (moveDone)
		(client scaleX: const scaleY: const)
		(super moveDone: &rest)
	)
)

