;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 992)
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
	)

	(method (init theObj)
		(= client theObj)
		(= cycleCnt 0)
		(client setCel: -1)
		(client startUpd:)
	)

	(method (nextCel)
		(++ cycleCnt)
		(return
			(if (<= cycleCnt (client cycleSpeed:))
				(client cel:)
			else
				(= cycleCnt 0)
				(if (& (client signal:) $1000)
					(client cel:)
				else
					(+ (client cel:) cycleDir)
				)
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
	(properties)

	(method (doit &tmp newCel)
		(if (not (client isStopped:))
			(super doit:)
		)
	)
)

(class Rev of Cycle
	(properties
		cycleDir -1
	)

	(method (doit &tmp newCel)
		(if (< (= newCel (self nextCel:)) 0)
			(self cycleDone:)
		else
			(client cel: newCel)
		)
	)

	(method (cycleDone)
		(client cel: (client lastCel:))
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
		(if (and (== cycleCnt 0) (== endCel (client cel:)))
			(self cycleDone:)
		)
	)

	(method (cycleDone)
		(= completed 1)
		(if caller
			(= global58 1)
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
	)

	(method (init actor xTo yTo toCall &tmp [temp0 2])
		(= client actor)
		(= x xTo)
		(= y yTo)
		(if (== argc 4)
			(= caller toCall)
		)
		(= b-moveCnt 0)
		(actor heading: (GetAngle (actor x:) (actor y:) xTo yTo))
		(if (actor looper:)
			((actor looper:) doit: actor (actor heading:))
		else
			(DirLoop actor (actor heading:))
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
		(DoBresen self)
		(if (and (== x (client x:)) (== y (client y:)))
			(self moveDone:)
			(return)
		)
	)

	(method (triedToMove)
		(return (== b-moveCnt 0))
	)

	(method (moveDone)
		(= completed 1)
		(if caller
			(= global58 1)
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

(class Wander of Motion
	(properties
		distance 0
	)

	(method (init theObj dist &tmp nx ny diam)
		(= distance (if (== argc 2) dist else 30))
		(= diam (* distance 2))
		(= nx (+ (theObj x:) (- distance (Random 1 diam))))
		(= ny (+ (theObj y:) (- distance (Random 1 diam))))
		(super init: theObj nx ny)
	)

	(method (setTarget &tmp temp0)
		(= temp0 (* distance 2))
		(= x (+ (client x:) (- distance (Random 1 temp0))))
		(= y (+ (client y:) (- distance (Random 1 temp0))))
	)

	(method (onTarget)
		(return 0)
	)

	(method (doit)
		(super doit:)
		(if (client isStopped:)
			(self moveDone:)
		)
	)

	(method (moveDone)
		(self init: client distance)
	)
)

(class Follow of Motion
	(properties
		who 0
		distance 0
	)

	(method (init theObj whom dist)
		(= who whom)
		(= client theObj)
		(= distance (if (< argc 3) 20 else dist))
		(if (> (client distanceTo: who) distance)
			(super init: theObj (who x:) (who y:))
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

	(method (doit &tmp angle)
		(if (> (client distanceTo: who) distance)
			(super doit:)
			(if (== b-moveCnt 0)
				(super init: client (who x:) (who y:))
			)
		else
			(= angle (GetAngle (client x:) (client y:) (who x:) (who y:)))
			(if (client looper:)
				((client looper:) doit: client angle)
			else
				(DirLoop client angle)
			)
		)
	)

	(method (moveDone))
)

(class Chase of Motion
	(properties
		who 0
		distance 0
	)

	(method (init actor whom howClose whoCares)
		(= client actor)
		(= who whom)
		(= distance howClose)
		(if (== argc 4)
			(= caller whoCares)
		)
		(super init: client (who x:) (who y:) caller)
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

	(method (doit)
		(if (<= (client distanceTo: who) distance)
			(self moveDone:)
		else
			(super doit:)
			(if (== b-moveCnt 0)
				(super init: client (who x:) (who y:) caller)
			)
		)
	)
)

