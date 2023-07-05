;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 945)
(include sci.sh)
(use Main)
(use Motion)

(public
	proc945_0 0
)

(procedure (proc945_0 param1 param2)
	(return
		(|
			(StrAt param1 (* 2 param2))
			(<< (StrAt param1 (+ 1 (* 2 param2))) $0008)
		)
	)
)

(class PolyPath of Motion
	(properties
		value 2
		points 0
	)

	(method (init param1 param2 param3 param4 param5)
		(if argc
			(= client param1)
			(if (> argc 1)
				(= points
					(AvoidPath
						(param1 x:)
						(param1 y:)
						param2
						param3
						(and
							(gCurRoom obstacles:)
							((gCurRoom obstacles:) elements:)
						)
						(and (gCurRoom obstacles:) ((gCurRoom obstacles:) size:))
						(if (>= argc 5) param5 else 1)
					)
				)
				(if (> argc 3)
					(= caller param4)
				)
			)
		)
		(self setTarget:)
		(super init:)
	)

	(method (dispose)
		(if points
			(Memory memFREE points)
		)
		(super dispose:)
	)

	(method (setTarget)
		(if (!= (proc945_0 points value) 30583)
			(= x (proc945_0 points value))
			(= y (proc945_0 points (++ value)))
			(++ value)
		)
	)

	(method (moveDone)
		(if (== (proc945_0 points value) 30583)
			(super moveDone:)
		else
			(self init:)
		)
	)
)

