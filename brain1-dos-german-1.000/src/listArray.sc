;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 426)
(include sci.sh)
(use Motion)
(use System)

(class listArray of Obj
	(properties
		size 0
	)

	(method (assign)
		(return 0)
	)

	(method (query)
		(return 0)
	)
)

(class DoEllipse of Motion
	(properties
		major 0
		minor 0
		cx 0
		cy 0
		step 5
		startAngle 0
		curAngle 0
	)

	(method (init param1 param2 param3 param4 param5 param6 param7)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= major param2)
				(if (>= argc 3)
					(= minor param3)
					(if (>= argc 4)
						(= cx param4)
						(if (>= argc 5)
							(= cy param5)
							(if (>= argc 6)
								(= step param6)
								(if (>= argc 7)
									(= startAngle param7)
								)
							)
						)
					)
				)
			)
		)
		(= x (+ cx (CosMult curAngle major)))
		(= y (+ cy (SinMult curAngle minor)))
		(+= curAngle step)
		(if (> curAngle 360)
			(-= curAngle 360)
		)
		(super init:)
	)

	(method (moveDone)
		(self init:)
	)
)

