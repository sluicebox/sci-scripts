;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64867)
(include sci.sh)
(use Main)
(use System)

(class MotionNoLoop of Obj
	(properties
		client 0
		caller 0
		x 0
		y 0
		dx 0
		dy 0
		b-moveCnt 0
		b-i1 0
		b-i2 0
		b-di 0
		b-xAxis 0
		b-incr 0
		completed 0
		xLast 0
		yLast 0
	)

	(method (init actor xTo yTo toCall &tmp cx cy)
		(if (>= argc 1)
			(= client actor)
			(if (>= argc 2)
				(= x xTo)
				(if (>= argc 3)
					(= y yTo)
					(if (>= argc 4)
						(= caller toCall)
					)
				)
			)
		)
		(= completed 0)
		(= xLast (client x:))
		(= yLast (client y:))
		(= b-moveCnt (+ 1 (client moveSpeed:) gGameTime))
		(if (= cy (client cycler:))
			(cy cycleCnt: b-moveCnt)
		)
		(InitBresen self)
	)

	(method (onTarget)
		(return (and (== (client x:) x) (== (client y:) y)))
	)

	(method (setTarget xTo yTo)
		(if argc
			(= x xTo)
			(= y yTo)
		)
	)

	(method (doit &tmp [temp0 6])
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(DoBresen self)
		)
	)

	(method (moveDone)
		(= completed 1)
		(self motionCue:)
	)

	(method (motionCue)
		(client mover: 0)
		(if (and completed caller)
			(if (not gCuees)
				(= gCuees (Set new:))
			)
			(gCuees add: ((Cue new:) cuee: caller yourself:))
		)
		(self dispose:)
	)
)

(class MoveToNoLoop of MotionNoLoop
	(properties)

	(method (onTarget)
		(return
			(and
				(<= (Abs (- (client x:) x)) (client xStep:))
				(<= (Abs (- (client y:) y)) (client yStep:))
			)
		)
	)
)

