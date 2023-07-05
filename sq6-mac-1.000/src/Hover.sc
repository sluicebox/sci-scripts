;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(local
	local0
	local1
)

(class Hover of Motion
	(properties
		cntrX 0
		cntrY 0
		radius 5
		xTilt 0
		yTilt 0
		angleStep 10
		winding 1
		curAngle 0
	)

	(method (init param1 param2 param3 param4 param5 param6 param7 param8 param9 &tmp temp0 temp1)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= local0 param2)
				(if (>= argc 3)
					(= local1 param3)
					(if (>= argc 4)
						(= radius param4)
						(if (>= argc 5)
							(= xTilt param5)
							(if (>= argc 6)
								(= yTilt param6)
								(if (>= argc 7)
									(= angleStep param7)
									(if (>= argc 8)
										(= winding param8)
										(if (>= argc 9)
											(= curAngle param9)
										)
									)
								)
							)
						)
					)
				)
			)
		)
		(if (<= local0 0)
			(= local0 (/ gScreenWidth 2))
		)
		(if (<= local1 0)
			(= local1 (/ gScreenHeight 2))
		)
		(= temp0 (SinMult curAngle radius))
		(= temp1 (CosMult (+ yTilt gPerspective) (CosMult curAngle radius)))
		(if xTilt
			(= temp0 (CosMult xTilt temp0))
			(+= temp1 (SinMult xTilt temp0))
		)
		(= x (+ local0 temp0))
		(= y (- local1 temp1))
		(= curAngle (umod (+ curAngle (* winding angleStep)) 360))
		(super init: client x y)
	)

	(method (moveDone)
		(self init:)
	)
)

