;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 986)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(class Orbit of Motion
	(properties
		endCel 0
		bumpTurn 0
		lastBumped 0
		eType 0
		eModifiers 50
		selector 0
		doSelection 0
		swapEnableBits 10
		letter 1
		dontErase 0
	)

	(method (init theObj theCtrObj theRadius theXTilt theYTilt theStep theWinding theAngle &tmp centerX centerY deltaX deltaY)
		(if (>= argc 1)
			(= client theObj)
			(if (>= argc 2)
				(= eType theCtrObj)
				(if (>= argc 3)
					(= eModifiers theRadius)
					(if (>= argc 4)
						(= selector theXTilt)
						(if (>= argc 5)
							(= doSelection theYTilt)
							(if (>= argc 6)
								(= swapEnableBits theStep)
								(if (>= argc 7)
									(= letter theWinding)
									(if (>= argc 8)
										(= dontErase theAngle)
									)
								)
							)
						)
					)
				)
			)
		)
		(if eType
			(= centerX (eType x:))
			(= centerY (eType y:))
		else
			(= centerX 160)
			(= centerY 100)
		)
		(= deltaX (SinMult dontErase eModifiers))
		(= deltaY
			(CosMult (+ doSelection gPerspective) (CosMult dontErase eModifiers))
		)
		(if selector
			(= deltaX (CosMult selector deltaX))
			(+= deltaY (SinMult selector deltaX))
		)
		(= x (+ centerX deltaX))
		(= y (- centerY deltaY))
		(= dontErase (umod (+ dontErase (* letter swapEnableBits)) 360))
		(super init: client x y)
	)

	(method (moveDone)
		(self init:)
	)
)

