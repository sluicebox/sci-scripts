;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 992)
(include sci.sh)
(use Main)
(use System)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3) ; UNUSED
	(if (< param5 param3)
		(= temp0 param5)
		(= temp2 param3)
	else
		(= temp0 param3)
		(= temp2 param5)
	)
	(if (< param6 param4)
		(= temp1 param6)
		(= temp3 param4)
	else
		(= temp1 param4)
		(= temp3 param6)
	)
	(return
		(and
			(<= temp0 param1)
			(>= temp2 param1)
			(<= temp1 param2)
			(>= temp3 param2)
		)
	)
)

(class Cycle of Obj
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
	)

	(method (init theObj)
		(if argc
			(= client theObj)
		)
		(= cycleCnt (- (- gGameTime (client cycleSpeed:)) 1))
		(= completed 0)
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
		(if (and completed (IsObject caller))
			(caller cue:)
		)
		(self dispose:)
	)
)

(class Fwd of Cycle
	(properties)

	(method (doit &tmp newCel)
		(if (> (= newCel (self nextCel:)) (client lastCel:))
			(self cycleDone:)
		else
			(client cel: newCel)
		)
	)

	(method (cycleDone)
		(client cel: 0)
	)
)

(class Walk of Fwd
	(properties
		x -1
		y -1
	)

	(method (init)
		(super init: &rest)
		(= x (client x:))
		(= y (client y:))
	)

	(method (doit &tmp newCel)
		(if (or (!= x (client x:)) (!= y (client y:)))
			(client cel: (+ (client cel:) 1))
			(if (>= (client cel:) (NumCels client))
				(client cel: 0)
			)
			(= x (client x:))
			(= y (client y:))
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
		(= last (client lastCel:))
		(= endCel (if (> toCel last) last else toCel))
	)

	(method (doit &tmp newCel last)
		(= last (client lastCel:))
		(if (> endCel last)
			(= endCel last)
		)
		(= newCel (self nextCel:))
		(client
			cel:
				(cond
					((> newCel last) 0)
					((< newCel 0) last)
					(else newCel)
				)
		)
		(if (and (== gGameTime cycleCnt) (== endCel (client cel:)))
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(if caller
			(= gDoMotionCue 1)
		else
			(self motionCue:)
		)
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

	(method (init actor xTo yTo toCall &tmp [DX 2] DY cy)
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
		(= b-moveCnt gGameTime)
		(= yLast (= xLast 0))
		(if (= cy (client cycler:))
			(cy cycleCnt: gGameTime)
		)
		(if (GetDistance (= DY (client x:)) (= cy (client y:)) x y)
			(client setHeading: (GetAngle DY cy x y))
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

	(method (doit)
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(DoBresen self)
		)
	)

	(method (moveDone)
		(= completed 1)
		(if caller
			(= gDoMotionCue 1)
		else
			(self motionCue:)
		)
	)

	(method (motionCue)
		(client mover: 0)
		(if (and completed (IsObject caller))
			(caller cue:)
		)
		(self dispose:)
	)
)

(class MoveTo of Motion
	(properties)

	(method (init)
		(super init: &rest)
	)

	(method (onTarget)
		(return
			(and
				(<= (Abs (- (client x:) x)) (client xStep:))
				(<= (Abs (- (client y:) y)) (client yStep:))
			)
		)
	)
)

(class NewFollow of Motion
	(properties
		who 0
		distance 30
		prevX -1
		prevY -1
		stoppedCnt 0
	)

	(method (init param1 param2 param3)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= who param2)
				(if (>= argc 3)
					(= distance param3)
				)
			)
		)
		(if (> (client distanceTo: who) distance)
			(super init: client (who x:) (who y:))
		)
	)

	(method (onTarget)
		(return (<= (client distanceTo: who) distance))
	)

	(method (setTarget)
		(cond
			(argc
				(super setTarget: &rest)
			)
			((not (self onTarget:))
				(super setTarget: (who x:) (who y:))
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(if (or (!= prevX (client x:)) (!= prevY (client y:)))
			(= prevX (client x:))
			(= prevY (client y:))
			(= stoppedCnt gGameTime)
		)
		(if (or (client cel:) (> (client distanceTo: who) distance))
			(if
				(or
					(client isBlocked:)
					(> (Abs (- gGameTime stoppedCnt)) (client moveSpeed:))
				)
				(= stoppedCnt gGameTime)
				(client cel: 0)
			else
				(if (not (client cycler:))
					(client setCycle: Walk)
				)
				(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
					(super init: client (who x:) (who y:))
					(= xLast prevX)
					(= yLast prevY)
					(= b-moveCnt gGameTime)
					(DoBresen self)
				)
			)
		else
			(= xLast prevX)
			(= yLast prevY)
			(= temp1 (GetAngle xLast yLast (who x:) (who y:)))
			(client heading: temp1)
			(if (client looper:)
				((client looper:) doit: client temp1)
			else
				(DirLoop client temp1)
			)
		)
		(if (and (== (client view:) 45) (client inRect: 0 0 258 156))
			(= temp0
				(and
					(not (client cel:))
					(> (Abs (- gGameTime stoppedCnt)) (client moveSpeed:))
				)
			)
			(client ignoreActors: temp0)
		)
	)

	(method (moveDone))
)

