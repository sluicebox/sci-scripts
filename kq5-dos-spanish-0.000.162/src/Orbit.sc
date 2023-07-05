;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 986)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class Orbit of Motion
	(properties
		centerObj 0
		radius 50
		xTilt 0
		yTilt 0
		angleStep 10
		winding 1
		curAngle 0
	)

	(method (init theObj theCtrObj theRadius theXTilt theYTilt theStep theWinding theAngle &tmp centerX centerY deltaX deltaY)
		(if (>= argc 1)
			(= client theObj)
			(if (>= argc 2)
				(= centerObj theCtrObj)
				(if (>= argc 3)
					(= radius theRadius)
					(if (>= argc 4)
						(= xTilt theXTilt)
						(if (>= argc 5)
							(= yTilt theYTilt)
							(if (>= argc 6)
								(= angleStep theStep)
								(if (>= argc 7)
									(= winding theWinding)
									(if (>= argc 8)
										(= curAngle theAngle)
									)
								)
							)
						)
					)
				)
			)
		)
		(if centerObj
			(= centerX (centerObj x:))
			(= centerY (centerObj y:))
		else
			(= centerX 160)
			(= centerY 100)
		)
		(= deltaX (SinMult curAngle radius))
		(= deltaY (CosMult (+ yTilt gPerspective) (CosMult curAngle radius)))
		(if xTilt
			(= deltaX (CosMult xTilt deltaX))
			(+= deltaY (SinMult xTilt deltaX))
		)
		(= x (+ centerX deltaX))
		(= y (- centerY deltaY))
		(= curAngle (umod (+ curAngle (* winding angleStep)) 360))
		(super init: client x y)
	)

	(method (moveDone)
		(self init:)
	)
)

