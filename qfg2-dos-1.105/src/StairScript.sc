;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use Motion)

(class StairScript of HandsOffScript
	(properties
		stairSize 0
		numStairs 0
		goingUp 0
		oldView 0
		oldCycle 0
		stairNumber 0
	)

	(method (init)
		(= oldView (gEgo view:))
		(= oldCycle (gEgo cycler:))
		(gEgo cycler: 0)
		(= stairNumber (/ numStairs 2))
		(super init: &rest)
	)

	(method (dispose)
		(gEgo view: oldView loop: (if goingUp 3 else 2) setCycle: oldCycle)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 3 loop: goingUp cel: 0)
				(if goingUp
					(gEgo y: (- (gEgo y:) (* stairSize 2)))
				else
					(gEgo y: (+ (gEgo y:) (* stairSize 2)))
				)
				(= cycles 1)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(cond
					((not (-- stairNumber))
						(self changeState: 3)
					)
					(goingUp
						(gEgo y: (- (gEgo y:) (* stairSize 2)))
					)
					(else
						(gEgo y: (+ (gEgo y:) (* stairSize 2)))
					)
				)
				(= state 0)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

