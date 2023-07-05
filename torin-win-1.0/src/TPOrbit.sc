;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64023)
(include sci.sh)
(use Main)
(use TPPolyPath)
(use System)

(class TPOrbit of TPPolyPath
	(properties
		centerObj 0
		angleStep 10
		radius 50
		curAngle 0
		xTilt 0
		yTilt 0
	)

	(method (setDefault)
		(super setDefault:)
		(= centerObj 0)
		(= angleStep 10)
		(= radius 50)
		(= yTilt (= xTilt (= curAngle 0)))
	)

	(method (setArgs actor)
		(if (>= argc 2)
			(= centerObj [actor 1])
			(if (>= argc 3)
				(= radius [actor 2])
				(if (>= argc 4)
					(= curAngle [actor 3])
					(if (>= argc 5)
						(= angleStep [actor 4])
						(if (>= argc 6)
							(= xTilt [actor 5])
							(if (>= argc 7)
								(= yTilt [actor 6])
								(if (>= argc 8)
									(= caller [actor 7])
								)
							)
						)
					)
				)
			)
		)
	)

	(method (newTarget &tmp centerX centerY deltaX deltaY)
		(if centerObj
			(= centerX (centerObj x:))
			(= centerY (centerObj y:))
		else
			(= centerX (/ gScreenWidth 2))
			(= centerY (/ gScreenHeight 2))
		)
		(= deltaX (SinMult curAngle radius))
		(= deltaY (CosMult (+ yTilt gPerspective) (CosMult curAngle radius)))
		(if xTilt
			(= deltaX (CosMult xTilt deltaX))
			(+= deltaY (SinMult xTilt deltaX))
		)
		(= finalX (+ centerX deltaX))
		(= finalY (- centerY deltaY))
		(= curAngle (umod (+ curAngle angleStep) 360))
	)

	(method (moveDone)
		(if (== (points at: value) 30583)
			(self init: client)
		else
			(self setTarget: init:)
		)
	)
)

