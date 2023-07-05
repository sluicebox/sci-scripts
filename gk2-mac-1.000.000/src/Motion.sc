;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64992)
(include sci.sh)
(use Main)
(use System)

(class Cycle of Obj
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		clientLastCel 0
	)

	(method (init theObj)
		(if argc
			(= client theObj)
		)
		(= cycleCnt gGameTime)
		(= completed 0)
		(= clientLastCel (client lastCel:))
	)

	(method (nextCel)
		(return
			(if (< (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
				(client cel:)
			else
				(= cycleCnt gGameTime)
				(+ (client cel:) cycleDir)
			)
		)
	)

	(method (cycleDone))

	(method (motionCue)
		(client cycler: 0)
		(if (and completed caller)
			(if (not gCuees)
				(= gCuees (Set new:))
			)
			(gCuees add: ((Cue new:) cuee: caller yourself:))
		)
		(self dispose:)
	)
)

(class Fwd of Cycle
	(properties)

	(method (doit &tmp newCel)
		(if (!= (client cel:) (= newCel (self nextCel:)))
			(if (> newCel clientLastCel)
				(self cycleDone:)
			else
				(client cel: newCel)
			)
		)
	)

	(method (cycleDone)
		(client cel: 0)
	)
)

(class Walk of Fwd
	(properties)

	(method (doit &tmp newCel)
		(if (not (client isStopped:))
			(super doit:)
		)
	)
)

(class CT of Cycle
	(properties
		endCel 0
	)

	(method (init actor toCel dir whoCares &tmp last)
		(super init: actor)
		(= cycleDir dir)
		(if (== argc 4)
			(= caller whoCares)
		)
		(= endCel (if (> toCel clientLastCel) clientLastCel else toCel))
	)

	(method (doit &tmp newCel currentCel)
		(if (!= (= currentCel (client cel:)) (= newCel (self nextCel:)))
			(if (== currentCel endCel)
				(self cycleDone:)
			else
				(client cel: newCel)
			)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(self motionCue:)
	)
)

(class End of CT
	(properties)

	(method (init actor whoCares)
		(super init: actor (actor lastCel:) 1 (if (== argc 2) whoCares else 0))
	)
)

(class Beg of CT
	(properties)

	(method (init actor whoCares)
		(super init: actor 0 -1 (if (== argc 2) whoCares else 0))
	)
)

(class SyncWalk of Fwd
	(properties
		xLast 0
		yLast 0
	)

	(method (doit &tmp theMover)
		(if (or (!= (client x:) xLast) (!= (client y:) yLast))
			(= xLast (client x:))
			(= yLast (client y:))
			(super doit:)
		)
	)

	(method (nextCel)
		(= cycleCnt (+ gGameTime (client cycleSpeed:)))
		(super nextCel:)
	)
)

(class Motion of Obj
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
		(if (GetDistance (= cx (client x:)) (= cy (client y:)) x y)
			(client
				setHeading: (GetAngle (* cx 4) (* cy 5) (* x 4) (* y 5))
			)
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

(class MoveTo of Motion
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

