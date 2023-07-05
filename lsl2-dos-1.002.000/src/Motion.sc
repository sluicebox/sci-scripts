;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 992)
(include sci.sh)
(use System)

(class Cycle of Obj
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
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
		(if (== endCel (client cel:))
			(= toCel (+ cycleDir (client cel:)))
			(client
				cel:
					(cond
						((> toCel last) 0)
						((< toCel 0) last)
						(else toCel)
					)
			)
		)
	)

	(method (doit &tmp newCel last)
		(= last (client lastCel:))
		(if (> endCel last)
			(= endCel last)
		)
		(if (== endCel (client cel:))
			(self cycleDone:)
		else
			(= newCel (self nextCel:))
			(client
				cel:
					(cond
						((> newCel last) 0)
						((< newCel 0) last)
						(else newCel)
					)
			)
		)
	)

	(method (cycleDone)
		(client cycler: 0)
		(if caller
			(caller cue:)
		)
		(self dispose:)
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

	(method (doit &tmp [temp0 6])
		(if (and (== x (client x:)) (== y (client y:)))
			(self moveDone:)
			(return)
		)
		(DoBresen self)
	)

	(method (triedToMove)
		(return (== b-moveCnt 0))
	)

	(method (moveDone)
		(client mover: 0)
		(if caller
			(caller cue:)
		)
		(self dispose:)
	)
)

(class MoveTo of Motion
	(properties)

	(method (init)
		(super init: &rest)
		(super doit:)
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
		(super doit:)
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
			(super doit:)
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
		(super doit:)
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

(class Avoid of Obj
	(properties
		client 0
		heading -1
		oldDir 0
		olderDir 0
		impulse 0
	)

	(method (init)
		(= heading -1)
		(= oldDir -2)
		(= olderDir -3)
		(= impulse 0)
	)

	(method (doit &tmp [str 40] motion curDir tries)
		(if (and (!= (= curDir (DoAvoider self)) -1) (client mover:))
			(= tries 0)
			(while (and (== curDir olderDir) (<= (++ tries) 1))
				(= heading -1)
				(= curDir (DoAvoider self))
			)
			(cond
				((or (== curDir olderDir) (== curDir oldDir))
					(+= impulse 1)
				)
				((and (> impulse 0) (not (client isBlocked:)))
					(= curDir oldDir)
					(-- impulse)
				)
				(else
					(= olderDir oldDir)
					(= oldDir curDir)
					(= impulse 1)
				)
			)
		)
		(if (!= curDir -1)
			(if (and (= motion (client mover:)) (motion isMemberOf: MoveTo))
				(client
					setMotion: MoveTo (motion x:) (motion y:) (motion caller:)
				)
			)
			(if (client looper:)
				((client looper:) doit: client curDir)
			else
				(DirLoop client curDir)
			)
			(if (not (client canBeHere:))
				(client findPosn:)
			)
		)
	)
)

